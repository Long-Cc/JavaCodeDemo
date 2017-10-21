package com.longc.login;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

public class ForceOfflineReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(final Context context, Intent intent) {
		AlertDialog.Builder dialog=new AlertDialog.Builder(context);
			dialog.setTitle("Warning")
			.setMessage("You are forced to be offline.Please try to login agin.")
			.setCancelable(false)//对话框不可取消
			.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					ActivityCollector.finishAll();//销毁所有的活动
					Intent intent = new Intent(context, LoginActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(intent);
				}
			});
		AlertDialog alertDialog=dialog.create();
		//设置AlertDialog类型，保证在广播接收器中可以正常弹出
		alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		alertDialog.show();
	}

}
