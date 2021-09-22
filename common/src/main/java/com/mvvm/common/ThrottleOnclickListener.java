package com.mvvm.common;

import android.view.View;
import android.view.View.OnClickListener;

import java.util.Calendar;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public abstract class ThrottleOnclickListener implements OnClickListener {
    public static OnClickListener callBack ;
    private int miniClickTime = -1;
    public static final int MIN_CLICK_DELAY_TIME = 300;
    private long lastClickTime = 0L;

    public ThrottleOnclickListener(int miniClickTime,OnClickListener callback) {
        this.miniClickTime = miniClickTime;
        callBack = callback ;
    }

    public ThrottleOnclickListener() {
    }

    @Override
    public void onClick(View v) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (this.miniClickTime == -1) {
            this.miniClickTime = 300;
        }

        if (currentTime - this.lastClickTime > (long)this.miniClickTime) {
            this.lastClickTime = currentTime;
            callBack.onClick(v);
        }

    }

    public abstract void onNoDoubleClick(View var1);
}
