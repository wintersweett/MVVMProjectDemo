package com.mvvm.common.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Keep;

import com.mvvm.base.application.BaseApplication;
import com.mvvm.base.utils.UtilsLog;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class ScreenUtils {
    public static int screenWidth = 0;
    public static int screenHeight = 0;
   public static WindowManager wm = (WindowManager) BaseApplication.getContext().getSystemService(
            Context.WINDOW_SERVICE);

    /**
     * 获得context的窗口参数
     *
     * @param context Activity
     * @return outMetrics
     */
    public static DisplayMetrics getWindowparameter(Activity context) {
        Display defaultDisplay = context.getWindow().getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(outMetrics);
        return outMetrics;
    }

    // 获取屏幕的大小
    public static Screen getScreenPix(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        return new Screen(dm.widthPixels, dm.heightPixels);
    }

    /**
     * 判断是否已经获取到了屏幕的宽高像素值。
     *
     * @return 始终返回true.<br/>
     * 如果没有获取到宽高则执行获取宽高操作并返回true.
     */
    public static boolean getScreenMetrics() {
        if (0 == screenWidth || 0 == screenHeight) {
            WindowManager wm = (WindowManager) BaseApplication.getContext().getSystemService(
                    Context.WINDOW_SERVICE);

            screenWidth = wm.getDefaultDisplay().getWidth();
            screenHeight = wm.getDefaultDisplay().getHeight();
        }
        return true;
    }
    public static int getScreenWidth(){
        return wm.getDefaultDisplay().getWidth();
    }
    public static int getScreenHeight(){
        return wm.getDefaultDisplay().getHeight();
    }
    @Keep
    public static class Screen {

        public int widthPixels;
        public int heightPixels;
        public float density;

        public Screen() {

        }

        public Screen(int widthPixels, int heightPixels) {
            this.widthPixels = widthPixels;
            this.heightPixels = heightPixels;
        }

        public Screen(int widthPixels, int heightPixels, float density) {
            this.widthPixels = widthPixels;
            this.heightPixels = heightPixels;
            this.density = density;
        }

        @Override
        public String toString() {
            return "(" + widthPixels + "," + heightPixels + ")";
        }

    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics;
    }
}
