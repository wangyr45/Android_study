package com.example.mp212;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper=new MyDatabaseHelper(this,"BookStore.db",null,2);
        Button createDatabase=(Button)findViewById(R.id.create_database);
        createDatabase.setOnClickListener(this);
        Button add_data=(Button)findViewById(R.id.add_data);
        add_data.setOnClickListener(this);
        Button update_data=(Button)findViewById(R.id.update_data);
        update_data.setOnClickListener(this);
        Button query_data=(Button)findViewById(R.id.query_data);
        query_data.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.create_database:
                dbHelper.getWritableDatabase();
                break;
            case R.id.add_data:
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();

                //开始组装第一条数据
                values.put("name", "The Da Vinci Code");
                values.put("author", "Dan Brown");
                values.put("pages", 454);
                values.put("price", 16.96);
                db.insert("Book", null, values);//插入第一条数据
                values.clear();
                //开始组装第二条数据
                values.put("name", "The Lost symbol");
                values.put("author", "Dan Brown");
                values.put("pages", 510);
                values.put("price", 19.95);
                db.insert("Book", null, values);//插入第二条数据
                break;
            case  R.id.update_data:
                SQLiteDatabase db2 = dbHelper.getWritableDatabase();
                ContentValues valuess = new ContentValues();
                valuess.put("price",10.99);
                db2.update("Book",valuess,"name = ?",new String[]{
                        "The Dan Vinci Code"});
                break;
            case  R.id.query_data:
                SQLiteDatabase db1 = dbHelper.getWritableDatabase();
                Cursor cursor = db1.query("Book",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do{
                        String name = cursor.getString(cursor.getColumnIndex("pages"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("MainActivity","book name is " + name);
                        Log.d("MainActivity","book author is " + author);
                        Log.d("MainActivity","book pages is " + pages);
                        Log.d("MainActivity","book price is " + price);
                    }while (cursor.moveToNext());
                }
                cursor.close();
                break;
            default:
        }
    }
}