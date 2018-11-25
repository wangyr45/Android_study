package com.example.sqlitelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button zhuce= (Button) findViewById(R.id.zhuce);
        Button delete= (Button) findViewById(R.id.delete);
        Button chaxun= (Button) findViewById(R.id.chaxun);
        Button genggai= (Button) findViewById(R.id.genggai);
        zhuce.setOnClickListener(this);
        delete.setOnClickListener(this);
        chaxun.setOnClickListener(this);
        genggai.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zhuce:
                intent = new Intent(MainActivity.this,ZhuCe.class);
                startActivity(intent);
                break;
            case R.id.delete:
                intent=new Intent(MainActivity.this, Delete.class);
                startActivity(intent);
                break;
            case  R.id.chaxun:
                intent=new Intent(MainActivity.this, ChaXun.class);
                startActivity(intent);
                break;
            case  R.id.genggai:
                intent=new Intent(MainActivity.this, GengGai.class);
                startActivity(intent);
                break;
            default:
        }
    }
}
