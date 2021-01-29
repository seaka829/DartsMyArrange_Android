package com.seaka.dartsmyarrange;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * トップ画面のフラグメント
 */
public class TopFragment extends Fragment {

    // UI
    DartsEffectButton startButton;
    DartsEffectButton editButton;


    /**
     * インスタンスを生成するメソッド
     * @return
     */
    public static TopFragment newInstance() {
        return new TopFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.top_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // スタートボタンの設定
        startButton = view.findViewById(R.id.start_button);
        startButton.setText(R.string.start_button);
        startButton.setColor(Constant.ColorType.I_ACCENT_COLOR);

        // 編集ボタン
        editButton = view.findViewById(R.id.edit_button);
        editButton.setText(R.string.edit_button);
        editButton.setColor(Constant.ColorType.I_BASE_COLOR);
    }
}
