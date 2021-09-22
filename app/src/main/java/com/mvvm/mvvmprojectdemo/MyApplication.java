package com.mvvm.mvvmprojectdemo;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.BuildConfig;
import com.alibaba.android.arouter.launcher.ARouter;
import com.kingja.loadsir.core.LoadSir;
import com.mvvm.base.application.BaseApplication;
import com.mvvm.base.loadsir.CustomCallback;
import com.mvvm.base.loadsir.EmptyCallback;
import com.mvvm.base.loadsir.ErrorCallback;
import com.mvvm.base.loadsir.LottieLoadingCallback;
import com.mvvm.base.loadsir.TimeoutCallback;
import com.mvvm.base.preference.PreferencesUtil;
import com.mvvm.base.utils.LogUtils;
import com.mvvm.base.utils.ToastUtil;
import com.mvvm.base.utils.UtilsLog;
import com.mvvm.net.base.BaseNetworkApi;

public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //ARouter调试开关
        if(BuildConfig.DEBUG){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);

        //环境
        PreferencesUtil.init(this);
        NetworkRequestInfo networkRequestInfo = new NetworkRequestInfo(this);
        BaseNetworkApi.init(networkRequestInfo);

        ToastUtil.init(this);
        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())//添加各种状态页
                .addCallback(new EmptyCallback())
                .addCallback(new LottieLoadingCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new CustomCallback())
                .setDefaultCallback(LottieLoadingCallback.class)//设置默认状态页
                .commit();

        //http log相关
        LogUtils.init(BuildConfig.DEBUG);
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
                UtilsLog.d("hm","线程："+t.getName()+"异常信息：："+e.getMessage());
            }
        });
    }
}
