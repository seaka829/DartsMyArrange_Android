package com.seaka.dartsmyarrange;

import android.os.Bundle;
import android.view.LayoutInflater;
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
    private DartsEffectButton singleOutButton;  // シングルアウトボタン
    private DartsEffectButton doubleOutButton;  // ダブルアウトボタン
    private DartsEffectButton masterOutButton;  // マスタアウトボタン

    // 設定値
    private int mode;   // モード


    /**
     * インスタンス生成メソッド
     * @param mode
     * @return
     */
    public static RuleFragment newInstance(int mode) {
        return new RuleFragment(mode);
    }


    /**
     * コンストラクター
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

        setUi();
    }


    /**
     * UIの設定
     */
    private void setUi() {
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);

        // ツールバーの非表示
        LinearLayout.LayoutParams toolbarLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 152);
        toolbar.setLayoutParams(toolbarLayoutParams);
        toolbar.setTitle("SELECT RULE");

        // モードごとにボタンの色を設定
        int color;
        switch (mode) {
            case Constant.Mode.I_GAME:
                color = Constant.ColorType.I_ACCENT_COLOR;
                break;
            case Constant.Mode.I_EDIT:
                color = Constant.ColorType.I_BASE_COLOR;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + mode);
        }

        // シングルアウトボタンの設定
        singleOutButton = getView().findViewById(R.id.single_out_button);
        singleOutButton.setText(R.string.single_out_button);
        singleOutButton.setColor(color);

        // ダブルアウトボタンの設定
        doubleOutButton = getView().findViewById(R.id.double_out_button);
        doubleOutButton.setText(R.string.double_out_button);
        doubleOutButton.setColor(color);

        // マスタアウトボタンの設定
        masterOutButton = getView().findViewById(R.id.master_out_button);
        masterOutButton.setText(R.string.master_out_button);
        masterOutButton.setColor(color);
    }
}
