package com.seaka.dartsmyarrange;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;


/**
 * アレンジリスト一覧画面のフラグメント
 */
public class ListFragment extends Fragment {

    // UI
    private Toolbar toolbar;    // ツールバー

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
     * コンストラクター
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

        setUi();
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
     * UIの設定
     */
    private void setUi() {

    }
}
