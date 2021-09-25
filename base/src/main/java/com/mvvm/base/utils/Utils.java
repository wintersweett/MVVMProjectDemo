package com.mvvm.base.utils;/*
 *
 *
 * History:
 */


import android.content.Context;
import android.util.SparseArray;

import java.util.Collection;
import java.util.Map;
/**
* @author :WinterSweett
 * @description
 *
*/
public class Utils {
    private static final String TAG = "Utils";
    private static final boolean DEBUG = false;

    public static boolean isEmpty(final String str) {
        return str == null || str.length() <= 0;
    }

    public static boolean isEmpty(final SparseArray sparseArray) {
        return sparseArray == null || sparseArray.size() <= 0;
    }

    public static boolean isEmpty(final Collection<? extends Object> collection) {
        return collection == null || collection.size() <= 0;
    }

    public static boolean isEmpty(final Map<? extends Object, ? extends Object> list) {
        return list == null || list.size() <= 0;
    }

    public static boolean isEmpty(final byte[] bytes) {
        return bytes == null || bytes.length <= 0;
    }

    public static boolean isEmpty(final String[] strArr) {
        return strArr == null || strArr.length <= 0;
    }

    public static int nullAs(final Integer obj, final int def) {
        return obj == null ? def : obj;
    }

    public static long nullAs(final Long obj, final long def) {
        return obj == null ? def : obj;
    }

    public static boolean nullAs(final Boolean obj, final boolean def) {
        return obj == null ? def : obj;
    }

    public static String nullAs(final String obj, final String def) {
        return obj == null ? def : obj;
    }

    public static String emptyAs(final String obj, final String def) {
        return isEmpty(obj) ? def : obj;
    }

    public static int nullAsNil(final Integer obj) {
        return obj == null ? 0 : obj;
    }

    public static long nullAsNil(final Long obj) {
        return obj == null ? 0L : obj;
    }

    public static String nullAsNil(final String obj) {
        return obj == null ? "" : obj;
    }


    public static boolean isEmpty(int[] si) {
        return si == null || si.length == 0;
    }
    /**
     * 校验电话号
     * 获取验证码
     *
     * @param str 手机号
     * @return true 可以获取验证码 false不可以
     */
    public static boolean isGetVerifiCode(Context context, String str) {

        if (!StringUtils.isNullOrEmpty(str) && str.length() > 10 && str.length() < 14) {
            if (str.length() == 11) {
                if (!"1".equals(str.substring(0, 1))) {
                    ToastUtil.show("请输入正确的手机号");
                    return false;
                } else {
                    return true;
                }
            } else if (str.length() == 12) {
                ToastUtil.show("请输入正确的手机号");

                return false;
            } else {
                if (!"00852".equals(str.substring(0, 5)) && !"00853".equals(str.substring(0, 5))) {
                    ToastUtil.show("请输入正确的手机号");

                    return false;
                } else {
                    return true;
                }
            }
        } else if (!StringUtils.isNullOrEmpty(str)) {
            ToastUtil.show("请输入正确的手机号");

            return false;
        } else {
            ToastUtil.show("请输入正确的手机号");

            return false;
        }
    }
}
