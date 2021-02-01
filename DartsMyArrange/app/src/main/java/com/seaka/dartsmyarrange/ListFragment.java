package com.seaka.dartsmyarrange;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

/**
 * アレンジリスト一覧画面のフラグメント
 */
public class ListFragment extends Fragment {

    // UI
    private Toolbar  toolbar;   // ツールバー
    private ListView listview;  // リストビュー

    // 設定値
    private int rule;   // ルール

    // 変数
    private ArrayList<ArrangeItem> items;       // アレンジ情報一覧
    private DatabaseAdapter databaseAdapter;    // データベースアダプタ

    /**
     * インスタンスの生成
     * @param rule
     * @return ListFragment
     */
    public static ListFragment newInstance(int rule) {
        return new ListFragment(rule);
    }

    /**
     * コンストラクタ
     * @param rule
     */
    public ListFragment(int rule) {
        this.rule = rule;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // DB接続
        databaseAdapter = new DatabaseAdapter(getActivity());
        databaseAdapter.open();

        getItems();
        setListview();
        setHasOptionsMenu(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        // DB切断
        databaseAdapter.close();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // ツールバーの設定
        toolbar = getActivity().findViewById(R.id.toolbar);
        LinearLayout.LayoutParams toolbarLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 152);
        toolbar.setLayoutParams(toolbarLayoutParams);
        toolbar.setTitle(Constant.Rule.getString(rule));

        // メニューの表示
        inflater.inflate(R.menu.menu_item, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.add_button) {
            // 編集画面へ遷移
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.replace(R.id.container,  EditFragment.newInstance(new ArrangeItem(), rule, Constant.InputType.I_CREATE));
            fragmentTransaction.commit();
        }
        else if(item.getItemId() == R.id.delete_button) {

            // ダイアログメッセージの設定
            String dialogMessage = null;
            String toastMessage  = null;
            if(rule == Constant.Rule.I_SINGLE_OUT) {
                dialogMessage = getResources().getString(R.string.dialog_message_init_single_out);
            }
            else if(rule == Constant.Rule.I_DOUBLE_OUT) {
                dialogMessage = getResources().getString(R.string.dialog_message_init_double_out);
            }
            else if(rule == Constant.Rule.I_MASTER_OUT) {
                dialogMessage = getResources().getString(R.string.dialog_message_init_master_out);
            }

            // ダイアログの設定と表示
            new AlertDialog.Builder(getContext())
                    .setTitle(getResources().getString(R.string.dialog_title))
                    .setMessage(dialogMessage)
                    .setPositiveButton(getResources().getString(R.string.dialog_positive), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            databaseAdapter.initTable(rule);
                            Toast.makeText(getActivity(), getResources().getString(R.string.toast_init_table), Toast.LENGTH_SHORT).show();
                            backFragment();
                        }
                    })
                    .setNegativeButton(getResources().getString(R.string.dialog_negative), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .show();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * アレンジ一覧をDBから取得
     */
    private void getItems() {

        // データベースからアレンジ一覧を取得
        Cursor cursor = databaseAdapter.getAll(rule);

        // items変数に格納
        items = new ArrayList<>();
        if(cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                items.add(new ArrangeItem(
                         cursor.getInt(cursor.getColumnIndex(DatabaseInfo.COL_ID))
                        ,cursor.getInt(cursor.getColumnIndex(DatabaseInfo.COL_TOTAL_POINT))
                        ,cursor.getInt(cursor.getColumnIndex(DatabaseInfo.COL_FIRST_TYPE))
                        ,cursor.getInt(cursor.getColumnIndex(DatabaseInfo.COL_FIRST_NUMBER))
                        ,cursor.getInt(cursor.getColumnIndex(DatabaseInfo.COL_SECOND_TYPE))
                        ,cursor.getInt(cursor.getColumnIndex(DatabaseInfo.COL_SECOND_NUMBER))
                        ,cursor.getInt(cursor.getColumnIndex(DatabaseInfo.COL_THIRD_TYPE))
                        ,cursor.getInt(cursor.getColumnIndex(DatabaseInfo.COL_THIRD_NUMBER))
                        ,cursor.getInt(cursor.getColumnIndex(DatabaseInfo.COL_IS_CHANGED))==1
                ));
            }
            while (cursor.moveToNext());
        }

    }

    /**
     * UIの設定
     */
    private void setListview() {
        listview = getActivity().findViewById(R.id.listview);
        ListAdapter adapter = new ListAdapter(getActivity(), R.layout.list_item, items);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(onItemClickListener);
    }

    /**
     * リストビュークリック時の処理
     */
    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // 編集画面へ遷移
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.replace(R.id.container,  EditFragment.newInstance(items.get(position), rule, Constant.InputType.I_UPDATE));
            fragmentTransaction.commit();
        }
    };

    /**
     * 一つ前のフラグメントへ戻る
     */
    private void backFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        if(fragmentManager != null) {
            fragmentManager.popBackStack();
        }
    }
}
