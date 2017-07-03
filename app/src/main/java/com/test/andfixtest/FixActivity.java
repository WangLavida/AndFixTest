package com.test.andfixtest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class FixActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix);
        textView = (TextView) findViewById(R.id.fix_text);
        init();
    }

    private void init() {
//        textView.setText("这是修复之前的");
        textView.setText("这是修复完成的,666");
    }
}
