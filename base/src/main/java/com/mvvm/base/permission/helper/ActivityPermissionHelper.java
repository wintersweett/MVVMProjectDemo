package com.mvvm.base.permission.helper;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

/**
 * @author : WinterSweett
 * @time : {DATE}
 * 符合运行时加载权限辅助类
 */
public class ActivityPermissionHelper extends PermissionHelper {

    ActivityPermissionHelper(Activity activity) {
        super(activity);
    }

    @Override
    public void requestPermissions(int requestCode, String... perms) {
        ActivityCompat.requestPermissions(getHost(),perms,requestCode);
    }

    @Override
    public boolean shouldShowRequestPermissionRationale(@NonNull String deniedPermission) {
        return ActivityCompat.shouldShowRequestPermissionRationale(getHost(),deniedPermission);
    }
}
