package com.example.sqlitelogin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChaXun extends AppCompatActivity {

    private MyDatabaseHelper dbH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chaxun);
        dbH = new MyDatabaseHelper(this,"Users.db",null,1);
        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText accountE = (EditText) findViewById(R.id.accountchaxun);
                String account = accountE.getText().toString();
                SQLiteDatabase db= dbH.getWritableDatabase();
                Cursor cursor=db.query(account,null,null,null,null,null,null);
                if (cursor.moveToFirst()) {
                    do {
                        String name=cursor.getString(cursor.getColumnIndex("xingming"));
                        Log.d(account,"的姓名是"+name);
                    }while (cursor.moveToNext());
                }
                else {
                    Toast.makeText(ChaXun.this,"该用户不存在",Toast.LENGTH_SHORT);
                }
                cursor.close();
            }
        });
        Button tuichu= (Button) findViewById(R.id.tuichud);
        tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ChaXun.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
