package com.mvvm.base.permission.helper;

import android.app.Activity;

import androidx.annotation.NonNull;

/**
 * @author : WinterSweett
 * @time : {DATE}
 * 低版本申请权限辅助类
 */
public class LowApiPermissionHelper extends PermissionHelper {
    LowApiPermissionHelper(Activity activity) {
        super(activity);
    }

    @Override
    public void requestPermissions(int requestCode, String... perms) {
        throw new IllegalStateException("低于6.0版本无须运行时请求权限");
    }

    @Override
    public boolean shouldShowRequestPermissionRationale(@NonNull String deniedPermission) {
        return false;
    }
}
