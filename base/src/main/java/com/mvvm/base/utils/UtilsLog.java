package com.mvvm.base.utils;


import com.alibaba.android.arouter.BuildConfig;

public class UtilsLog {

	public static boolean isTest = BuildConfig.DEBUG;
	public static boolean isWrite = BuildConfig.DEBUG;


	public static void d(String key, String value) {
		if (isTest && value == null) {
			android.util.Log.d(key, "###############ZHOUYA#############");
		}else if (isTest){
			android.util.Log.d(key,value);
		}
	}

	public static void i(String key, String value) {
		if (isTest && value == null) {
			android.util.Log.d(key, "###############ZHOUYA#############");
		}else if (isTest){
			android.util.Log.i(key,value);
		}
	}

	public static void e(String key, String value) {
		if (isTest && value == null) {
			android.util.Log.d(key, "###############ZHOUYA#############");
		}else if (isTest){
			android.util.Log.e(key, value);
		}
	}

	public static void w(String key, String value) {
		if (isTest && value == null) {//5.2.0  打印日志value不能为null,为空时打印特定字符串
			android.util.Log.d(key, "###############ZHOUYA#############");
		}else if (isTest){
			android.util.Log.w(key, value);
		}
		if (isWrite && value!= null) {
			StringUtils.writeToSDCardPre(key+":"+value,"/zouya/log/","UrlAndCrash",100);
		}
	}

	public static void log(String tag, String info) {
		StackTraceElement[] ste = new Throwable().getStackTrace();
		int i = 1;
		if (isTest) {
			StackTraceElement s = ste[i];
			android.util.Log.e(tag, String.format("======[%s][%s][%s]=====%s",
					s.getClassName(), s.getLineNumber(), s.getMethodName(),
					info));
		}
	}

}
