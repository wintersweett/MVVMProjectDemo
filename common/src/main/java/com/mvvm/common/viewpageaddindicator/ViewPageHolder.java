package com.mvvm.common.viewpageaddindicator;

import android.content.Context;
import android.view.View;
/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/
public interface ViewPageHolder<T> {
    /**
     * @param:
    *创建view
    */
    View createView(Context context) ;
    /**
     * @param:
    *绑定数据
    */
    void onBind(Context context , int position , T data);
}
