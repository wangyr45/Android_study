package com.example.mp88;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ProgressBar progressBar,progressBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button3.setOnClickListener(this);
        Button buttonprogress = (Button) findViewById(R.id.buttonprogress);
        buttonprogress.setOnClickListener(this);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        progressBar= (ProgressBar) findViewById(R.id.progress_bar);
        progressBar2= (ProgressBar) findViewById(R.id.progress_bar2);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button3:
                if(progressBar.getVisibility()==View.GONE) {
                    progressBar.setVisibility(View.VISIBLE);
                }else {
                    progressBar.setVisibility(View.GONE);
                }
                break;
            case R.id.button4:
                int progress=progressBar2.getProgress();
                progress=progress+10;
                progressBar2.setProgress(progress);
                break;
            case R.id.buttonprogress:
                ProgressDialog pro=new ProgressDialog(MainActivity.this);
                pro.setTitle("This is a ProgressDialog");
                pro.setMessage("Loading……");
                pro.setCancelable(true);
                pro.show();
                break;
            default:   break;
        }
    }
}
