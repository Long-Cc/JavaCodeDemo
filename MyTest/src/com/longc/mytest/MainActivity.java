package com.longc.mytest;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {
	private Button  btn_main;
	private ImageView iv_main;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_main=(Button) findViewById(R.id.btn_main);
		iv_main=(ImageView) findViewById(R.id.iv_main);
		btn_main.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		new AlertDialog.Builder(MainActivity.this)
			.setTitle("this is dialog")
			.setMessage("Something important")
			.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					iv_main.setImageResource(R.drawable.android);
				}
			})
			.setNegativeButton("cancel", null).show();
	}
}
