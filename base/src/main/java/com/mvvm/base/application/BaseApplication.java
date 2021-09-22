package com.mvvm.base.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;


import java.util.Stack;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author : WinterSweett
 * @time : {DATE}
 * 全app 的context
 */
public class BaseApplication extends Application {
    static Application sApplication ;
    public static Stack<Activity> store ;
    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        store = new Stack<>();
    }
    public static Context getContext(){
        return sApplication ;
    }
    /**
     * @param:
    * 获取当前activity
    */
    public Activity getCurActivity(){
        return store.lastElement() ;//返回栈顶activity
    }
}
