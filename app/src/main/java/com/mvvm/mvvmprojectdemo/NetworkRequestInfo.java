package com.mvvm.mvvmprojectdemo;


import android.app.Application;

import com.alibaba.android.arouter.BuildConfig;
import com.mvvm.net.base.INetworkRequiredInfo;


/**
* @author :WinterSweett
 * @description
 *
*/
public class NetworkRequestInfo implements INetworkRequiredInfo {
    private Application mApplication;
    public NetworkRequestInfo(Application application){
        this.mApplication = application;
    }

    @Override
    public String getAppVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    @Override
    public String getAppVersionCode() {
        return String.valueOf(BuildConfig.VERSION_CODE);
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    @Override
    public Application getApplicationContext() {
        return mApplication;
    }
}
