package com.seaka.dartsmyarrange;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;


/**
 * ルール選択画面のフラグメント
 */
public class RuleFragment extends Fragment {

    // UI
    private Toolbar           toolbar;          // ツールバー
    private DartsEffectButton singleOutButton;  // シングルアウトボタン
    private DartsEffectButton doubleOutButton;  // ダブルアウトボタン
    private DartsEffectButton masterOutButton;  // マスタアウトボタン

    // 設定値
    private int mode;   // モード


    /**
     * インスタンスの生成
     * @param mode
     * @return
     */
    public static RuleFragment newInstance(int mode) {
        return new RuleFragment(mode);
    }


    /**
     * コンストラクタ
     * @param mode
     */
    public RuleFragment(int mode) {
        this.mode = mode;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.rule_fragment, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setButton();
        setHasOptionsMenu(true);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // ツールバーの設定
        toolbar = getActivity().findViewById(R.id.toolbar);
        LinearLayout.LayoutParams toolbarLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0);
        toolbar.setLayoutParams(toolbarLayoutParams);
        toolbar.setTitle(null);
    }


    /**
     * UIの設定
     */
    private void setButton() {
        // モードごとにボタンの色を設定
        switch (mode) {
            case Constant.Mode.I_GAME:
                // シングルアウトボタンの設定
                singleOutButton = getView().findViewById(R.id.single_out_button);
                singleOutButton.setText(R.string.single_out_button);
                singleOutButton.setColor(Constant.ColorType.I_ACCENT_COLOR);
//                singleOutButton.setTransition(getFragmentManager(), ListFragment.newInstance(Constant.Rule.I_SINGLE_OUT));

                // ダブルアウトボタンの設定
                doubleOutButton = getView().findViewById(R.id.double_out_button);
                doubleOutButton.setText(R.string.double_out_button);
                doubleOutButton.setColor(Constant.ColorType.I_ACCENT_COLOR);
//                doubleOutButton.setTransition(getFragmentManager(), ListFragment.newInstance(Constant.Rule.I_DOUBLE_OUT));

                // マスタアウトボタンの設定
                masterOutButton = getView().findViewById(R.id.master_out_button);
                masterOutButton.setText(R.string.master_out_button);
                masterOutButton.setColor(Constant.ColorType.I_ACCENT_COLOR);
//                masterOutButton.setTransition(getFragmentManager(), ListFragment.newInstance(Constant.Rule.I_MASTER_OUT));
                break;
            case Constant.Mode.I_EDIT:
                // シングルアウトボタンの設定
                singleOutButton = getView().findViewById(R.id.single_out_button);
                singleOutButton.setText(R.string.single_out_button);
                singleOutButton.setColor(Constant.ColorType.I_BASE_COLOR);
                singleOutButton.setTransition(getFragmentManager(), ListFragment.newInstance(Constant.Rule.I_SINGLE_OUT));

                // ダブルアウトボタンの設定
                doubleOutButton = getView().findViewById(R.id.double_out_button);
                doubleOutButton.setText(R.string.double_out_button);
                doubleOutButton.setColor(Constant.ColorType.I_BASE_COLOR);
                doubleOutButton.setTransition(getFragmentManager(), ListFragment.newInstance(Constant.Rule.I_DOUBLE_OUT));

                // マスタアウトボタンの設定
                masterOutButton = getView().findViewById(R.id.master_out_button);
                masterOutButton.setText(R.string.master_out_button);
                masterOutButton.setColor(Constant.ColorType.I_BASE_COLOR);
                masterOutButton.setTransition(getFragmentManager(), ListFragment.newInstance(Constant.Rule.I_MASTER_OUT));
                break;
        }
    }
}
