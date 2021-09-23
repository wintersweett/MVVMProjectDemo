package com.mvvm.common.viewpageaddindicator;

import android.content.Context;
import android.view.View;
/**
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
