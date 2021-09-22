package com.mvvm.base.utils;

import android.view.View;
import android.view.View.OnClickListener;

import java.util.Calendar;

import androidx.fragment.app.Fragment;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public abstract class OnNoDoubleListener extends Fragment implements OnClickListener {

        private int miniClickTime = -1;
        public static final int MIN_CLICK_DELAY_TIME = 300;
        private long lastClickTime = 0L;

        public OnNoDoubleListener(int miniClickTime) {
            this.miniClickTime = miniClickTime;
        }

        public OnNoDoubleListener() {
        }

        @Override
        public void onClick(View v) {
            long currentTime = Calendar.getInstance().getTimeInMillis();
            if (this.miniClickTime == -1) {
                this.miniClickTime = 2000;
            }

            if (currentTime - this.lastClickTime > (long)this.miniClickTime) {
                this.lastClickTime = currentTime;
                this.onNoDoubleClick(v);
            }

        }

        public abstract void onNoDoubleClick(View var1);


}
