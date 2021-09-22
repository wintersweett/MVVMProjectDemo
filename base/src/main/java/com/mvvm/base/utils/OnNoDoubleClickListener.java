package com.mvvm.base.utils;

import android.view.View;

import java.util.Calendar;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public abstract class OnNoDoubleClickListener {

        private int miniClickTime = -1;
        public static final int MIN_CLICK_DELAY_TIME = 300;
        private long lastClickTime = 0L;

        public OnNoDoubleClickListener(int miniClickTime) {
            this.miniClickTime = miniClickTime;
        }

        public OnNoDoubleClickListener() {
        }

        public void onClick(View v) {
            long currentTime = Calendar.getInstance().getTimeInMillis();
            if (this.miniClickTime == -1) {
                this.miniClickTime = 300;
            }

            if (currentTime - this.lastClickTime > (long)this.miniClickTime) {
                this.lastClickTime = currentTime;
                this.onNoDoubleClick(v);
            }

        }

        public abstract void onNoDoubleClick(View var1);


}
