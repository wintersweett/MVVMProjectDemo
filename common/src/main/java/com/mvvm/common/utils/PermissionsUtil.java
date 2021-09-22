package com.mvvm.common.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.content.ContextCompat;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class PermissionsUtil {
    /**允许程序访问摄像头进行拍照*/
    public static final String CAMERA = Manifest.permission.CAMERA;
    /**允许程序读sd卡*/
    public static final String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    /**	允许程序写sd卡*/
    public static final String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    /**
     * 检查应用是否拥有权限
     * @param permissions  需要检查的权限
     * @return  true | 拥有全部权限   false | 拥有部分或者没有权限
     */
    public static boolean checkPermissions(Context context , String... permissions){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }

        if (context == null) {
            throw new IllegalArgumentException("Can't check permissions for null context");
        }

        for (String perm : permissions) {
            if (ContextCompat.checkSelfPermission(context, perm) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }
}
