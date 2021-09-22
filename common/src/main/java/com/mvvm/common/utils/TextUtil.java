package com.mvvm.common.utils;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class TextUtil {
    public static void setStyle(String str){
      // String ss = "<font color =\"#FFFD453A\>"

    }
    /**
     * @param:
    *设置字符串中数字的颜色与大小
    */
    public static SpannableStringBuilder setNumColor(String str) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (a >= '0' && a <= '9') {
                //设置颜色
                style.setSpan(new ForegroundColorSpan(Color.RED), i, i + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                //设置大小
             //   style.setSpan(new RelativeSizeSpan(3.0f), i, i + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            }
        }
        return style;
    }}
