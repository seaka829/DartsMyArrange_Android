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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


/**
 * アレンジ編集画面のフラグメント
 */
public class EditFragment extends Fragment {

    // UI
    private Toolbar toolbar;                // 合計得点
    private TextView firstTypeTextview;     // 一投目の倍率
    private TextView secondTypeTextview;    // 二投目の倍率
    private TextView thirdTypeTextview;     // 三投目の倍率
    private Spinner firstTypeSpinner;       // 一投目のスピナー
    private Spinner secondTypeSpinner;      // 二投目のスピナー
    private Spinner thirdTypeSpinner;       // 三投目のスピナー
    private EditText totalPointEdittext;    // 合計点数
    private EditText firstNumberEdittext;   // 一投目のナンバー
    private EditText secondNumberEdittext;  // 二投目のナンバー
    private EditText thirdNumberEdittext;   // 三投目のナンバー
    private Button submitButton;            // 決定ボタン
    private Button deleteButton;            // 削除ボタン

    // 設定値
    private int rule;       // ルール
    private int inputType;  // 入力タイプ

    // 変数
    private ArrangeItem item;                   // アレンジ情報
    private DatabaseAdapter databaseAdapter;    // データベースアダプタ


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

        // DB接続
        databaseAdapter = new DatabaseAdapter(getActivity());
        databaseAdapter.open();

        setUi();
        setScreen();
        drawPoint();
        setSpinner();
        setEdittext();
        setButton();
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
        firstTypeTextview = getView().findViewById(R.id.first_type_textview);
        secondTypeTextview = getView().findViewById(R.id.second_type_textview);
        thirdTypeTextview = getView().findViewById(R.id.third_type_textview);
        firstTypeSpinner = getView().findViewById(R.id.first_type_spinner);
        secondTypeSpinner = getView().findViewById(R.id.second_type_spinner);
        thirdTypeSpinner = getView().findViewById(R.id.third_type_spinner);
        totalPointEdittext = getView().findViewById(R.id.total_point_edittext);
        firstNumberEdittext = getView().findViewById(R.id.first_number_edittext);
        secondNumberEdittext = getView().findViewById(R.id.second_number_edittext);
        thirdNumberEdittext = getView().findViewById(R.id.third_number_edittext);
        submitButton = getView().findViewById(R.id.submit_button);
        deleteButton = getView().findViewById(R.id.delete_button);
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
            deleteButton.setVisibility(View.GONE);
        }
        else if(inputType == Constant.InputType.I_UPDATE) {
            // 入力不可能に設定
            totalPointEdittext.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.main_color));
            totalPointEdittext.setTextColor(ContextCompat.getColor(getContext(), R.color.white_color));
            totalPointEdittext.setEnabled(false);
            deleteButton.setVisibility(View.VISIBLE);
        }
    }


    /**
     * 点数の描画
     */
    private void drawPoint() {
        // 合計点数の描画
        totalPointEdittext.setText(String.valueOf(item.getTotalPoint()));

        // ナンバーの描画
        firstNumberEdittext.setText(String.valueOf(item.getFirstNumber()));
        secondNumberEdittext.setText(String.valueOf(item.getSecondNumber()));
        thirdNumberEdittext.setText(String.valueOf(item.getThirdNumber()));

        // スピナーに値の設定
        firstTypeSpinner.setSelection(item.getFirstType());
        secondTypeSpinner.setSelection(item.getSecondType());
        thirdTypeSpinner.setSelection(item.getThirdType());

        // 倍率の描画
        firstTypeTextview.setText(Constant.PointType.getString(item.getFirstType()));
        secondTypeTextview.setText(Constant.PointType.getString(item.getSecondType()));
        thirdTypeTextview.setText(Constant.PointType.getString(item.getThirdType()));

        // エディットテキストの表示・非表示設定
        if(item.getFirstType()==Constant.PointType.I_NULL || item.getFirstType()==Constant.PointType.I_BULL) {
            firstNumberEdittext.setVisibility(View.GONE);
        }
        else {
            firstNumberEdittext.setVisibility(View.VISIBLE);
        }
        if(item.getSecondType()==Constant.PointType.I_NULL || item.getSecondType()==Constant.PointType.I_BULL) {
            secondNumberEdittext.setVisibility(View.GONE);
        }
        else {
            secondNumberEdittext.setVisibility(View.VISIBLE);
        }
        if(item.getThirdType()==Constant.PointType.I_NULL || item.getThirdType()==Constant.PointType.I_BULL) {
            thirdNumberEdittext.setVisibility(View.GONE);
        }
        else {
            thirdNumberEdittext.setVisibility(View.VISIBLE);
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
        firstNumberEdittext.addTextChangedListener(textWatcher);
        secondNumberEdittext.addTextChangedListener(textWatcher);
        thirdNumberEdittext.addTextChangedListener(textWatcher);
    }


    /**
     * ボタンクリック時の設定
     */
    private void setButton() {
        submitButton.setOnClickListener(onClickListener);
        deleteButton.setOnClickListener(onClickListener);
    }


    /**
     * スピナークリック時の処理
     */
    private AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
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
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // エディット変更時にitemに値を保存
            try {
                item.setTotalPoint(Integer.parseInt(totalPointEdittext.getText().toString()));
            }
            catch (NumberFormatException e) {
                item.setTotalPoint(0);
            }
            try {
                item.setFirstNumber(Integer.parseInt(firstNumberEdittext.getText().toString()));
            }
            catch (NumberFormatException e) {
                item.setFirstNumber(0);
            }
            try {
                item.setSecondNumber(Integer.parseInt(secondNumberEdittext.getText().toString()));
            }
            catch (NumberFormatException e) {
                item.setSecondNumber(0);
            }
            try {
                item.setThirdNumber(Integer.parseInt(thirdNumberEdittext.getText().toString()));
            }
            catch (NumberFormatException e) {
                item.setThirdNumber(0);
            }
        }
    };


    /**
     * ボタンクリック時の処理
     */
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            // OKボタンクリック時
            if(view.getId() == R.id.submit_button) {
                if(item.checkReg() == Constant.ErrType.I_NONE_ERR) {

                    // 登録処理
                    if (inputType == Constant.InputType.I_CREATE) {
                        databaseAdapter.register(rule, item);
                    } else if (inputType == Constant.InputType.I_UPDATE) {
                        databaseAdapter.update(rule, item);
                    }
                    Toast.makeText(getActivity(), getResources().getString(R.string.toast_reg_item), Toast.LENGTH_SHORT).show();
                    backFragment();
                }
                else if(item.checkReg() == Constant.ErrType.I_RANGE_ERR) {
                    Toast.makeText(getActivity(), getResources().getString(R.string.toast_reg_err1), Toast.LENGTH_SHORT).show();
                }
                else if(item.checkReg() == Constant.ErrType.I_CALC_ERR) {
                    Toast.makeText(getActivity(), getResources().getString(R.string.toast_reg_err2), Toast.LENGTH_SHORT).show();
                }
            }

            // 削除ボタンクリック時
            else if(view.getId() == R.id.delete_button) {

                // 削除処理
                databaseAdapter.delete(rule, item);
                Toast.makeText(getActivity(), getResources().getString(R.string.toast_delete_item),Toast.LENGTH_SHORT).show();
                backFragment();
            }
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
