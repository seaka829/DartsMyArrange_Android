package com.seaka.dartsmyarrange;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


/**
 * アレンジ編集画面のフラグメント
 */
public class EditFragment extends Fragment {

    // UI
    private Toolbar toolbar;                // 合計得点
    private Spinner firstTypeSpinner;       // 一投目の倍率
    private Spinner secondTypeSpinner;      // 二投目の倍率
    private Spinner thirdTypeSpinner;       // 三投目の倍率
    private EditText totalPointEdittext;    // 合計点数
    private EditText firstPointEdittext;    // 一投目のナンバー
    private EditText secondPointEdittext;   // 二投目のナンバー
    private EditText thirdPointEdittext;    // 三投目のナンバー

    // 設定値
    private ArrangeItem item;   // アレンジ情報
    private int rule;           // ルール
    private int inputType;      // 入力タイプ


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
        this.item = item;
        this.rule = rule;
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

        setUi();
        setScreen();
        drawPoint();
        setSpinner();
        setEdittext();
        setHasOptionsMenu(true);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // ツールバーの設定
        LinearLayout.LayoutParams toolbarLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 152);
        toolbar.setLayoutParams(toolbarLayoutParams);
        toolbar.setTitle(Constant.Rule.getString(rule));
    }


    /**
     * UIの設定
     */
    private void setUi() {
        // UIの取得
        toolbar = getActivity().findViewById(R.id.toolbar);
        firstTypeSpinner = getView().findViewById(R.id.first_type_spinner);
        secondTypeSpinner = getView().findViewById(R.id.second_type_spinner);
        thirdTypeSpinner = getView().findViewById(R.id.third_type_spinner);
        totalPointEdittext = getView().findViewById(R.id.total_point_edittext);
        firstPointEdittext = getView().findViewById(R.id.first_number_edittext);
        secondPointEdittext = getView().findViewById(R.id.second_number_edittext);
        thirdPointEdittext = getView().findViewById(R.id.third_number_edittext);
    }


    /**
     * 入力タイプより画面の設定
     */
    private void setScreen() {
        if(inputType == Constant.InputType.I_CREATE) {
            // 入力可能に設定
            totalPointEdittext.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.main_border));
            totalPointEdittext.setTextColor(ContextCompat.getColor(getContext(), R.color.main_color));
            totalPointEdittext.setEnabled(true);
        }
        else if(inputType == Constant.InputType.I_UPDATE) {
            // 入力不可能に設定
            totalPointEdittext.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.main_color));
            totalPointEdittext.setTextColor(ContextCompat.getColor(getContext(), R.color.white_color));
            totalPointEdittext.setEnabled(false);
        }
    }


    /**
     * 点数の描画
     */
    private void drawPoint() {
        // 点数の描画
        totalPointEdittext.setText(String.valueOf(item.getTotalPoint()));
        firstPointEdittext.setText(String.valueOf(item.getFirstNumber()));
        secondPointEdittext.setText(String.valueOf(item.getSecondNumber()));
        thirdPointEdittext.setText(String.valueOf(item.getThirdNumber()));
        firstTypeSpinner.setSelection(item.getFirstType());
        secondTypeSpinner.setSelection(item.getSecondType());
        thirdTypeSpinner.setSelection(item.getThirdType());

        // エディットテキストの表示・非表示設定
        if(item.getFirstType()==Constant.PointType.I_NULL || item.getFirstType()==Constant.PointType.I_BULL) {
            firstPointEdittext.setVisibility(View.GONE);
        }
        else {
            firstPointEdittext.setVisibility(View.VISIBLE);
        }
        if(item.getSecondType()==Constant.PointType.I_NULL || item.getSecondType()==Constant.PointType.I_BULL) {
            secondPointEdittext.setVisibility(View.GONE);
        }
        else {
            secondPointEdittext.setVisibility(View.VISIBLE);
        }
        if(item.getThirdType()==Constant.PointType.I_NULL || item.getThirdType()==Constant.PointType.I_BULL) {
            thirdPointEdittext.setVisibility(View.GONE);
        }
        else {
            thirdPointEdittext.setVisibility(View.VISIBLE);
        }
    }


    /**
     * スピナー項目変更時の処理を設定
     */
    private void setSpinner() {
        firstTypeSpinner.setOnItemSelectedListener(onItemSelectedListener);
        secondTypeSpinner.setOnItemSelectedListener(onItemSelectedListener);
        thirdTypeSpinner.setOnItemSelectedListener(onItemSelectedListener);
    }


    /**
     * エディットテキスト変更時の処理を設定
     */
    private void setEdittext() {
        totalPointEdittext.addTextChangedListener(textWatcher);
        firstPointEdittext.addTextChangedListener(textWatcher);
        secondPointEdittext.addTextChangedListener(textWatcher);
        thirdPointEdittext.addTextChangedListener(textWatcher);
    }


    /**
     * スピナークリック時の処理
     */
    AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            // 選択した項目をitemにセット
            if(parent.getId() == R.id.first_type_spinner) {
                item.setFirstType(position);
            }
            else if(parent.getId() == R.id.second_type_spinner) {
                item.setSecondType(position);
            }
            else if(parent.getId() == R.id.third_type_spinner) {
                item.setThirdType(position);
            }

            // 点数の再描画
            drawPoint();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };


    /**
     * エディットテキスト入力時の処理
     */
    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // エディット変更後にitemに値を保存
            item.setTotalPoint(Integer.parseInt(totalPointEdittext.getText().toString()));
            item.setFirstNumber(Integer.parseInt(firstPointEdittext.getText().toString()));
            item.setSecondNumber(Integer.parseInt(secondPointEdittext.getText().toString()));
            item.setThirdNumber(Integer.parseInt(thirdPointEdittext.getText().toString()));
        }
    };
}
