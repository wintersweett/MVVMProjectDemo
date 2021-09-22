package com.mvvm.net.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.mvvm.base.application.BaseApplication;


public class PhoneUtils {
    public static String getVersion(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = BaseApplication.getContext().getPackageManager().getPackageInfo(BaseApplication.getContext().getPackageName(),0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo.versionName;
    }
    public static int getVersionCode(){
        int versionCode = 0;
        try {
            //TODO
           ApplicationInfo applicationInfo = BaseApplication.getContext().getPackageManager().getApplicationInfo(BaseApplication.getContext().getPackageName(),0);
//             versionCode = applicationInfo.metaData.getInt("VERSION_CODE");
            versionCode = 850 ;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }
}
