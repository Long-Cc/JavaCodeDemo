package com.longc.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
	private EditText et_acount;
	private EditText et_password;
	
	private Button btn_login;
	
	private SharedPreferences pref;
	private SharedPreferences.Editor editor;
	private CheckBox remember_pass;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		et_acount=(EditText) findViewById(R.id.et_acount);
		et_password=(EditText) findViewById(R.id.et_password);
		btn_login=(Button) findViewById(R.id.btn_login);
		
		pref=PreferenceManager.getDefaultSharedPreferences(this);
		remember_pass=(CheckBox) findViewById(R.id.remember_pass);
		boolean isRemember=pref.getBoolean("remember_password", false);
		
		if(isRemember){
			//将账户和密码都设置在文本框
			String account=pref.getString("acount", "");
			String password=pref.getString("password", "");
			et_acount.setText(account);
			et_password.setText(password);
			remember_pass.setChecked(true);
		}
		
		btn_login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String account=et_acount.getText().toString();
				String password=et_password.getText().toString();
				if(account.equals("admin")&&password.equals("123456")){
					editor=pref.edit();
					if(remember_pass.isChecked()){
						editor.putBoolean("remember_password", true);
						editor.putString("account", account);
						editor.putString("password", password);
					}else{
						editor.clear();
					}
					editor.commit();
					Intent intent=new Intent(LoginActivity.this,MainActivity.class);
					startActivity(intent);
					finish();
				}else{
					Toast.makeText(LoginActivity.this, "账号或密码不正确！", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
	}
}
