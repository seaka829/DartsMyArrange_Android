package com.seaka.dartsmyarrange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;


/**
 * アクティビティ
 */
public class MainActivity extends AppCompatActivity {

    // UI
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ツールバーの設定
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(null);
        setSupportActionBar(toolbar);

        // Fragmentの設置
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, TopFragment.newInstance()).commitNow();
        }
    }
}
