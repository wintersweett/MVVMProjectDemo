package com.mvvm.base.utils;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mvvm.base.R;


/**
* @author :WinterSweett
 * @description
 *
*/
public class ToastUtil {
	private static Toast mToast;
	private static Context context;
	public static void init(Context context) {
		ToastUtil.context = context;
	}

	public static void show(String msg) {
		try {
			if (context != null && !TextUtils.isEmpty(msg)) {
				if(mToast != null){
					mToast.cancel();
				}
				View v = LayoutInflater.from(context).inflate(R.layout.toast_my, null);
				TextView tv_content = (TextView) v.findViewById(R.id.tv_content);
				tv_content.setText(msg);
				mToast = new Toast(context);
				mToast.setView(v);
//				mToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
//				mToast.setText(msg);
				mToast.setGravity(Gravity.CENTER, 0, 0);
				mToast.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void toastForThread(Context context,String text){
		if(Looper.getMainLooper().getThread() != Thread.currentThread()) {
			Looper.prepare();
			initToast(context,text);
			Looper.loop();
		}else {
			initToast(context,text);
		}


	}

	public static void initToast(Context context,String text){
		Toast toast = new Toast(context);
		View v = LayoutInflater.from(context).inflate(R.layout.toast, null);
		toast.setView(v);
		TextView tv_toast = (TextView) v.findViewById(R.id.tv_toast);
		if (text != null && text.length() != 0) {
			tv_toast.setText(text);
		}
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}
}
