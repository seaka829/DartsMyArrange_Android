package com.seaka.dartsmyarrange;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DartsEffectButton extends ConstraintLayout {

    // 定数
    private int iconSize        = 80;   // ダーツアイコンのサイズ
    private int animationSpeed  = 200;  // アニメーションの速度

    // UI
    private View        shadow;     // 影
    private View        background; // 背景
    private View        border;     // ボーダー
    private Button      button;     // ボタン
    private ImageView   icon;       // ダーツアイコン

    // 設定値
    private FragmentManager fragmentManager;    // フラグメントマネージャー
    private Object          fragment;           // 遷移先のフラグメント

    /**
     * ダーツエフェクトボタン生成時に呼ばれる
     * @param context
     * @param attrs
     */
    public DartsEffectButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        setUi();
    }


    /**
     * UIの設定
     */
    private void setUi() {
        // 影のレイアウト設定と生成
        ConstraintLayout.LayoutParams shadowLayoutParams = new ConstraintLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        shadowLayoutParams.startToStart = this.getId();
        shadowLayoutParams.endToEnd = this.getId();
        shadowLayoutParams.topToTop = this.getTop();
        shadowLayoutParams.bottomToBottom = this.getId();
        shadowLayoutParams.setMargins(16, 16, 0, 0);
        shadow = new View(getContext());
        shadow.setLayoutParams(shadowLayoutParams);
        shadow.setBackgroundColor(getResources().getColor(R.color.shadow_color));
        this.addView(shadow);

        // 背景のレイアウト設定と生成
        ConstraintLayout.LayoutParams backgroundLayoutParams = new ConstraintLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        backgroundLayoutParams.startToStart = this.getId();
        backgroundLayoutParams.endToEnd = this.getId();
        backgroundLayoutParams.topToTop = this.getTop();
        backgroundLayoutParams.bottomToBottom = this.getId();
        backgroundLayoutParams.setMargins(8, 8,  8, 8);
        background = new View(getContext());
        background.setLayoutParams(backgroundLayoutParams);
        background.setBackgroundColor(getResources().getColor(R.color.white_color));
        this.addView(background);

        // ボーダーのレイアウト設定と生成
        ConstraintLayout.LayoutParams borderLayoutParams = new ConstraintLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        borderLayoutParams.startToStart = this.getId();
        borderLayoutParams.endToEnd = this.getId();
        borderLayoutParams.topToTop = this.getTop();
        borderLayoutParams.bottomToBottom = this.getId();
        borderLayoutParams.setMargins(16, 16, 16, 16);
        border = new View(getContext());
        border.setLayoutParams(borderLayoutParams);
        this.addView(border);

        // ボタンのレイアウト設定と生成
        ConstraintLayout.LayoutParams buttonLayoutParams = new ConstraintLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        buttonLayoutParams.startToStart = this.getId();
        buttonLayoutParams.endToEnd = this.getId();
        buttonLayoutParams.topToTop = this.getTop();
        buttonLayoutParams.bottomToBottom = this.getId();
        buttonLayoutParams.setMargins(8, 8, 8, 8);
        button = new Button(getContext());
        button.setLayoutParams(buttonLayoutParams);
        button.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.alpha0_color));
//        button.setTypeface(Typeface.createFromAsset(getResources().getAssets(), "changa_medium.ttf"));
        button.setTextSize(40);
        button.setOnClickListener(onClickListener);
        this.addView(button);

        // ダーツアイコンのレイアウト設定と生成（非表示）
        ConstraintLayout.LayoutParams iconLayoutParams = new ConstraintLayout.LayoutParams(iconSize, iconSize);
        icon = new ImageView(getContext());
        icon.setLayoutParams(iconLayoutParams);
        icon.setVisibility(View.GONE);
        this.addView(icon);
    }


    /**
     * ダーツエフェクトボタンクリック時の処理
     */
    private OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dartsEffect();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // 指定時間[ms]後の処理を実行
                    transition();
                }
            }, animationSpeed+100);
        }
    };


    /**
     * ダーツアイコンのアニメーション
     */
    private void dartsEffect() {
        // ダーツアイコンの表示
        icon.setVisibility(View.VISIBLE);

        // ダーツアイコンの移動位置の設定
        Float startX = button.getScaleX() + button.getWidth()/2 + iconSize;
        Float startY = button.getScaleY();
        Float startR = 30f;
        Float endX = button.getScaleX() + button.getWidth()/2 - iconSize;
        Float endY = button.getScaleY() + button.getHeight() - iconSize;
        Float endR = 0f;

        // ダーツアイコンのアニメーション設定
        PropertyValuesHolder propertyValuesHolderX = PropertyValuesHolder.ofFloat( "translationX", startX, endX );
        PropertyValuesHolder propertyValuesHolderY = PropertyValuesHolder.ofFloat( "translationY", startY, endY );
        PropertyValuesHolder propertyValuesHolderR = PropertyValuesHolder.ofFloat( "rotation", startR, endR);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(icon, propertyValuesHolderX, propertyValuesHolderY, propertyValuesHolderR);
        objectAnimator.setDuration(animationSpeed);
        objectAnimator.start();
    }


    /**
     * 遷移処理
     */
    private void transition() {
        if(fragmentManager != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.replace(R.id.container, (Fragment)fragment);
            fragmentTransaction.commit();
        }
    }


    /**
     * 遷移先の設定
     * @param fragmentManager
     * @param fragment
     */
    public void setTransition(FragmentManager fragmentManager, Object fragment) {
        this.fragmentManager = fragmentManager;
        this.fragment = fragment;
    }


    /**
     * ボタンテキストの設定
     * @param text
     */
    public void setText(int text) {
        button.setText(getResources().getString(text));
    }


    /**
     * ダーツエフェクトボタンの色設定
     * @param colorType
     */
    public void setColor(int colorType) {
        int borderColor;
        int textColor;
        int iconColor;

        // 色種別ごとにパーツの色を設定
        switch (colorType) {
            case Constant.ColorType.I_MAIN_COLOR:
                borderColor = R.drawable.main_border;
                textColor = R.color.main_color;
                iconColor = R.mipmap.main_darts;
                break;
            case Constant.ColorType.I_BASE_COLOR:
                borderColor = R.drawable.base_border;
                textColor = R.color.base_color;
                iconColor = R.mipmap.base_darts;
                break;
            case Constant.ColorType.I_ACCENT_COLOR:
                borderColor = R.drawable.accent_border;
                textColor = R.color.accent_color;
                iconColor = R.mipmap.accent_darts;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + colorType);
        }

        // パーツの色設定
        button.setTextColor(getResources().getColor(textColor));
        border.setBackground(getResources().getDrawable(borderColor));
        icon.setImageResource(iconColor);
    }
}
