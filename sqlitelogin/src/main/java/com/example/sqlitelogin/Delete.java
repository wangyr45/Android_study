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

public class Delete extends AppCompatActivity {

    private MyDatabaseHelper dbH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        dbH = new MyDatabaseHelper(this,"Users.db",null,1);
        Button del = (Button) findViewById(R.id.delete);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText accountE = (EditText) findViewById(R.id.accountdelete);
                String account = accountE.getText().toString();
                SQLiteDatabase db= dbH.getWritableDatabase();
                db.execSQL("delete from USER where account=?",new String[]{account});
                Log.d(account,"------------删除成功");
            }
        });
        Button tuichu= (Button) findViewById(R.id.tuichuc);
        tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Delete.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
