package com.example.m109;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //隐藏自带标题栏
        ActionBar actionbar=getSupportActionBar();
        if(actionbar!=null) {
            actionbar.hide();
        }
    }
}

