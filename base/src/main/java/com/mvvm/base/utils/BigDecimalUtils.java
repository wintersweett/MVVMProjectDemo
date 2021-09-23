package com.mvvm.base.utils;

import android.util.Log;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class BigDecimalUtils {
    public static double formatDouble2(double d){
        BigDecimal bigDecimal = new BigDecimal(d);
        double bg = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return bg;

    }
    public static String format(double price){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
       String string = decimalFormat.format(formatDouble2(price));
       return string;

    }

}
