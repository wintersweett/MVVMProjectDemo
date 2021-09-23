package com.mvvm.net.base;

import android.app.Application;
/**
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
