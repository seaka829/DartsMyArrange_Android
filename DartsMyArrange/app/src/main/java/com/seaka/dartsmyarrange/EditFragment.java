package com.seaka.dartsmyarrange;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

/**
 * アレンジ編集画面のフラグメント
 */
public class EditFragment extends Fragment {

    // UI
    private Toolbar toolbar;
    private Spinner firstTypeSpinner;
    private Spinner secondTypeSpinner;
    private Spinner thirdTypeSpinner;

    // 設定値
    private ArrangeItem item;       // アレンジ情報
    private int         rule;       // ルール
    private int         inputType;  // 入力タイプ


    /**
     * インスタンスの生成
     * @param item
     * @param rule
     * @param inputType
     * @return
     */
    public static EditFragment newInstance(ArrangeItem item, int rule, int inputType) {
        return new EditFragment(item, rule, inputType);
    }


    /**
     * コンストラクタ
     * @param item
     * @param rule
     * @param inputType
     */
    private EditFragment(ArrangeItem item, int rule, int inputType) {
        this.item      = item;
        this.rule      = rule;
        this.inputType = inputType;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.edit_fragment, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setSpinner();
        setHasOptionsMenu(true);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // ツールバーの設定
        toolbar = getActivity().findViewById(R.id.toolbar);
        LinearLayout.LayoutParams toolbarLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 152);
        toolbar.setLayoutParams(toolbarLayoutParams);
        toolbar.setTitle(Constant.Rule.getString(rule));

    }


    /**
     * スピナーの設定
     */
    private void setSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add(Constant.PointType.S_NULL);
        adapter.add(Constant.PointType.S_SINGLE);
        adapter.add(Constant.PointType.S_DOUBLE);
        adapter.add(Constant.PointType.S_TRIPLE);
        adapter.add(Constant.PointType.S_BULL);

        firstTypeSpinner = getView().findViewById(R.id.first_type_spinner);
//        firstTypeSpinner.setAdapter(adapter);
        secondTypeSpinner = getView().findViewById(R.id.second_type_spinner);
//        secondTypeSpinner.setAdapter(adapter);
        thirdTypeSpinner = getView().findViewById(R.id.third_type_spinner);
//        thirdTypeSpinner.setAdapter(adapter);
    }
}
