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
 * トップ画面のフラグメント
 */
public class TopFragment extends Fragment {

    // UI
    Toolbar toolbar;
    DartsEffectButton startButton;
    DartsEffectButton editButton;


    /**
     * インスタンスの生成
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

        setUi();
        setHasOptionsMenu(true);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // ツールバーの設定
        toolbar = getActivity().findViewById(R.id.toolbar);
        LinearLayout.LayoutParams toolbarLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0);
        toolbar.setLayoutParams(toolbarLayoutParams);
        toolbar.setTitle("");
    }


    /**
     * UIの設定
     */
    private void setUi() {
        // スタートボタンの設定
        startButton = getView().findViewById(R.id.start_button);
        startButton.setText(R.string.start_button);
        startButton.setColor(Constant.ColorType.I_ACCENT_COLOR);
        startButton.setTransition(getFragmentManager(), RuleFragment.newInstance(Constant.Mode.I_GAME));

        // 編集ボタン
        editButton = getView().findViewById(R.id.edit_button);
        editButton.setText(R.string.edit_button);
        editButton.setColor(Constant.ColorType.I_BASE_COLOR);
        editButton.setTransition(getFragmentManager(), RuleFragment.newInstance(Constant.Mode.I_EDIT));
    }
}
