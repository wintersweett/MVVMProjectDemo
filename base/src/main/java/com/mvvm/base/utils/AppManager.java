package com.mvvm.base.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.text.TextUtils;

import com.mvvm.base.model.BaseModel;
import com.mvvm.base.viewmodel.BaseViewModel;

import java.util.List;
import java.util.Stack;

/**
 * @author : WinterSweett
 * @time : {DATE}
 * activity管理
 */
public class AppManager {
    private static Stack<Activity> acitivtyStack ;
    private static Stack<BaseViewModel> viewModelsStack ;
    private volatile static AppManager instance ;
    private AppManager(){

    }
    public static AppManager getInstance(){
        if(instance == null){
            synchronized (AppManager.class){
                if(instance == null){
                    instance = new AppManager();
                    acitivtyStack = new Stack<>();
                    viewModelsStack = new Stack<>();
                }
            }
        }
        return instance;
    }
    public boolean contains(Class clazz){
        if(acitivtyStack == null) {
            return false;
        }
        for(Activity activity : acitivtyStack){
            if(activity.getClass().getName().equals(clazz.getName())){
                return true;
            }
        }
        return false;

    }

    public void addActivity(Activity activity){
        if(activity == null){
            acitivtyStack = new Stack<>();
        }
        acitivtyStack.add(activity);
    }
    public Activity getCurActivity(){
        Activity activity = acitivtyStack.lastElement();
        return activity;
    }
    public void finishActivity(){
        Activity activity = acitivtyStack.lastElement();
        finishActivity(activity);
    }

    public void finishActivity(Activity activity){
        if(activity != null){
            acitivtyStack.remove(activity);
            activity.finish();
        }
    }

    public void removeActivity(Activity activity){
        if(activity != null){
            acitivtyStack.remove(activity);
        }
    }
    public int getActivityCount(){
        return acitivtyStack.size();
    }

    public void finishAllActivity(){
        for(int i =0 ;i <acitivtyStack.size() ;i ++){
            if (null != acitivtyStack.get(i)) {
                acitivtyStack.get(i).finish();
            }
        }
        acitivtyStack.clear();
    }



    public <M extends BaseModel> void addViewModel(BaseViewModel mdBaseViewModel) {
        viewModelsStack.add(mdBaseViewModel);

    }
    public <M extends BaseModel> void remove(BaseViewModel mdBaseViewModel) {
        viewModelsStack.remove(mdBaseViewModel);

    }
    public void finishAllViewModels(){
        for(int i =0 ;i <acitivtyStack.size() ;i ++){
            if (null != acitivtyStack.get(i)) {
                acitivtyStack.get(i).finish();
            }
        }
        acitivtyStack.clear();
    }


}
