package com.seaka.dartsmyarrange;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

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
    private Toolbar                toolbar;     // ツールバー
    private ListView               listview;    // リストビュー
    private ArrayList<ArrangeItem> items;       //アレンジ情報一覧

    // 設定値
    private int rule;           // ルール


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

        getItems();
        setListview();
        setHasOptionsMenu(true);
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
            Log.d("test", "追加");
        }
        else if(item.getItemId() == R.id.delete_button) {
            Log.d("test", "削除");
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * アレンジ一覧をDBから取得
     */
    private void getItems() {
        // テストデータ
        items = new ArrayList<>();
        items.add(new ArrangeItem(0, 150, 3, 20, 3, 20, 3, 20));
        items.add(new ArrangeItem(0, 180, 1, 20, 3, 20, 3, 20));
        items.add(new ArrangeItem(0, 180, 2, 20, 1, 20, 3, 20));
        items.add(new ArrangeItem(0, 180, 3, 20, 2, 20, 1, 20));
        items.add(new ArrangeItem(0, 180, 4, 20, 3, 20, 2, 20));
        items.add(new ArrangeItem(0, 180, 0, 20, 4, 20, 3, 20));
        items.add(new ArrangeItem(0, 180, 3, 20, 0, 20, 4, 20));
        items.add(new ArrangeItem(0, 180, 3, 20, 3, 20, 0, 20));
        items.add(new ArrangeItem(0, 180, 3, 20, 3, 20, 3, 20));
        items.add(new ArrangeItem(0, 180, 3, 20, 3, 20, 3, 20));
        items.add(new ArrangeItem(0, 180, 3, 20, 3, 20, 3, 20));
        items.add(new ArrangeItem(0, 180, 3, 20, 3, 20, 3, 20));
        items.add(new ArrangeItem(0, 180, 3, 20, 3, 20, 3, 20));
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
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.replace(R.id.container,  EditFragment.newInstance(items.get(position), rule, Constant.InputType.I_UPDATE));
            fragmentTransaction.commit();
        }
    };
}
