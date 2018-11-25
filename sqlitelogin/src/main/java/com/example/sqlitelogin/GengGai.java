package com.example.sqlitelogin;

import android.content.ContentValues;
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

public class GengGai extends AppCompatActivity {

    private MyDatabaseHelper dbH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genggai);
        dbH = new MyDatabaseHelper(this,"Users.db",null,1);
        Button geng = (Button) findViewById(R.id.genggai1);
        geng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText accountE = (EditText) findViewById(R.id.accountl);
                String account = accountE.getText().toString();
                EditText p1 = (EditText) findViewById(R.id.password1);
                EditText p2 = (EditText) findViewById(R.id.password2);
                EditText p22 = (EditText) findViewById(R.id.password22);
                String pp1 = p1.getText().toString();
                String pp2 = p2.getText().toString();
                String pp22 = p22.getText().toString();
                SQLiteDatabase db= dbH.getWritableDatabase();
                Cursor cursor=db.query(account,null,null,null,null,null,null);
                if (cursor.moveToFirst()) {
                        String password=cursor.getString(cursor.getColumnIndex("password"));
                        if(password.equals(pp1)) {
                            Toast.makeText(GengGai.this,"旧密码正确",Toast.LENGTH_SHORT);
                            if(pp2.equals(pp22)){
                                ContentValues values=new ContentValues();
                                values.put("password",pp2);
                                db.update("USER",values,"account=?",new String[]{account});
                                Log.d(account,"更改成功");
                            }
                        }else {
                            Toast.makeText(GengGai.this,"旧密码错误",Toast.LENGTH_SHORT);
                        }
                }
                cursor.close();


            }
        });
        Button tuichu= (Button) findViewById(R.id.tuichub);
        tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GengGai.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
