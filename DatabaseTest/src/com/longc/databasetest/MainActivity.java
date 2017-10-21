package com.longc.databasetest;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private MyDatabaseHelper dbHelper;
	
	private Button create_database;
	private Button add_data;
	private Button update_data;
	private Button delete_data;
	private Button query_data;
	private Button replace_data;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dbHelper=new MyDatabaseHelper(this, "BookStore", null, 1);
		
		create_database=(Button) findViewById(R.id.create_database);
		add_data=(Button) findViewById(R.id.add_data);
		update_data=(Button) findViewById(R.id.update_data);
		delete_data=(Button) findViewById(R.id.delete_data);
		query_data=(Button) findViewById(R.id.query_data);
		replace_data=(Button) findViewById(R.id.replace_data);
		
		create_database.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dbHelper.getWritableDatabase();	
			}
		});
		add_data.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SQLiteDatabase db=dbHelper.getWritableDatabase();
				ContentValues values=new ContentValues();
				values.put("name", "The Da Vinci Code");
				values.put("author", "Dan Brown");
				values.put("pages", 410);
				values.put("price", 19.99);
				db.insert("Book", null, values);
				values.clear();
				
				values.put("name", "The Lost Symbol");
				values.put("author", "Dan Brown");
				values.put("pages", 510);
				values.put("price", 19.95);
				db.insert("Book", null, values);
				
			}
		});
		update_data.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SQLiteDatabase db=dbHelper.getWritableDatabase();
				ContentValues values=new ContentValues();
				values.put("price", 10.99);
				db.update("Book", values, "name=?", new String[]{"The Da Vinci Code"});
			}
		});
		delete_data.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SQLiteDatabase db=dbHelper.getWritableDatabase();
				db.delete("Book", "pages>?", new String[]{"500"});
			}
		});
		query_data.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SQLiteDatabase db=dbHelper.getWritableDatabase();
				Cursor cursor = db.query("Book", null, null, null, null, null, null);
				if(cursor.moveToFirst()){
					do{
						String name=cursor.getString(cursor.getColumnIndex("name"));
						String author=cursor.getString(cursor.getColumnIndex("author"));
						int pages=cursor.getInt(cursor.getColumnIndex("pages"));
						double price=cursor.getDouble(cursor.getColumnIndex("price"));
						
						Log.e("TAG", name+"-"+author+"-"+pages+"-"+price);
					}while(cursor.moveToNext());
				}
				cursor.close();
			}
		});
		replace_data.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SQLiteDatabase db=dbHelper.getWritableDatabase();
				db.beginTransaction();//开启事务
				try {
					db.delete("Book", null, null);
					ContentValues values=new ContentValues();
					values.put("name", "Game of Thrones");
					values.put("author", "George Martin");
					values.put("pages", 720);
					values.put("price", 20.99);
					db.insert("Book", null, values);
					db.setTransactionSuccessful();//事务已经执行成功
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					db.endTransaction();//结束事务
				}
			}
		});
	}
}
