package com.mvvm.net.base;

import android.app.Application;
/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/
public interface INetworkRequiredInfo {
    String getAppVersionName();
    String getAppVersionCode();
    boolean isDebug();
    Application getApplicationContext();
}
