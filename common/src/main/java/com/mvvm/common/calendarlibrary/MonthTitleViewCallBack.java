package com.mvvm.common.calendarlibrary;

import android.view.View;

import java.util.Date;

/**
 * github:https://github.com/sy007
 */
public interface MonthTitleViewCallBack {
    /**
     * 提供外部设置MonthTitleView
     *
     * @param position adapter的position位置
     * @param date     月份日期
     * @return
     */
    View getMonthTitleView(int position, Date date);
}
