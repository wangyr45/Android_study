package com.example.sqlitelogin;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ZhuCe extends AppCompatActivity {

        private MyDatabaseHelper dbH;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_zhuce);
            dbH = new MyDatabaseHelper(this,"Users.db",null,1);
            Button z = (Button) findViewById(R.id.zhucez);
            z.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText accountz = (EditText) findViewById(R.id.accountz);
                    EditText xingmingz = (EditText) findViewById(R.id.xingmingz);
                    EditText passwordz = (EditText) findViewById(R.id.passwordz);
                    EditText repasswordz = (EditText) findViewById(R.id.repasswordz);
                    String account = accountz.getText().toString();
                    String xingming = xingmingz.getText().toString();
                    String password = passwordz.getText().toString();
                    String repassword = repasswordz.getText().toString();
                    if(password.equals(repassword)) {

                        SQLiteDatabase db= dbH.getWritableDatabase();
                        ContentValues values=new ContentValues();
                        values.put("account",account);
                        values.put("xingming",xingming);
                        values.put("password",password);
                        db.insert("USER",null,values);
                        values.clear();
                        Log.d("--------------"+account,"注册成功");
                    }else {
                        Log.d("--------------"+account,"请请重新输入密码");
                    }
                }
            });
            Button tuichu= (Button) findViewById(R.id.tuichua);
            tuichu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(ZhuCe.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

