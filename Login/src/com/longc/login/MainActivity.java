package com.longc.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private Button btn_main_offline;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_main_offline=(Button) findViewById(R.id.btn_main_offline);
		
		btn_main_offline.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent("com.example.broadcastbestpractice.FORCE_OFFLINE");
				sendBroadcast(intent);
			}
		});
	}
}
