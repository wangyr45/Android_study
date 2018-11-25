package com.example.m109;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by 璞毓 on 2018/10/24.
 */

public class TitleLayout extends LinearLayout {
    //引入TitleLayout控件
    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        //对标题栏布局进行动态加载
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button titleBack=(Button)findViewById(R.id.title_back);
        Button titleEdit=(Button)findViewById(R.id.title_edit);
        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)getContext()).finish();
            }
        });
        titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"You clicked Edit button",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
