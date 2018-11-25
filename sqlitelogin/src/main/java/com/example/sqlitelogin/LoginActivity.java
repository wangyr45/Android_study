package com.example.sqlitelogin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private MyDatabaseHelper dbH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbH = new MyDatabaseHelper(this,"Users.db",null,1);
        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText accountE = (EditText) findViewById(R.id.accountl);
                EditText passwordE = (EditText) findViewById(R.id.passwordl);
                String account = accountE.getText().toString();
                String password = passwordE.getText().toString();
                SQLiteDatabase db= dbH.getWritableDatabase();
                Cursor cursor=db.query(account,null,null,null,null,null,null);
                if (cursor.moveToFirst()) {
                    String passwordz=cursor.getString(cursor.getColumnIndex("password"));
                    if(password.equals(passwordz)) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();

                    }}
                cursor.close();
            }
        });
        Button tuichu= (Button) findViewById(R.id.tuichu1);
        tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Button zhuce= (Button) findViewById(R.id.zhucel);
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(LoginActivity.this,ZhuCe.class);
                startActivity(intent);
            }
        });
    }
}
