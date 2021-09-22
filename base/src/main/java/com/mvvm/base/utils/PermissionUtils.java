package com.mvvm.base.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

public class PermissionUtils {
    /**跳转应用详情设置权限*/
    public static final int APP_SETTINGS_RC = 10050;
    /**请求闪屏页的必要权限*/
    public static final int REQUEST_SPLASH_PERMISSIONS = 10060;
    /**请求摄像头的权限*/
    public static final int REQUEST_CAMERA = 10061;
    /**请求拨打电话的权限*/
    public static final int REQUEST_CALL_OHONE = 10062;
    /**请求读取通讯录权限*/
    /**请求读取存储卡权限*/
    public static final int REQUEST_READ_EXTERNAL_STORAGE = 10064;
    /**请求读取手机信息的权限*/
   // public static final int REQUEST_READ_PHONE_STATE = 10065;
    /**请求读取存储卡的权限*/
    public static final int REQUEST_EXTERNAL_STORAGE = 10066;
    /**请求读取存储卡、相机的权限*/
    public static final int REQUEST_CAMERA_EXTERNAL_STORAGE = 10067;
    /**请求读取存储卡、相机的权限*/
    public static final int REQUEST_CAMERA_EXTERNAL_STORAGE_RECORDAUDIO = 10068;
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

    /**
     * 处理被拒绝授权的应用
     * @param activity
     * @param permissions
     * @param requestCode
     */
    public static void handleDeniedPermissions(final Activity activity, List<String> permissions, final int requestCode){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("提示");
        builder.setMessage(getMessageContent(permissions));
        builder.setCancelable(false);
        builder.setPositiveButton("去设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                openSettings(activity);
            }
        });
        //设置反面按钮
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private static void openSettings(Activity activity) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
        intent.setData(uri);
        try {
           activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示权限提示的内容
     * @param permissions 已被拒绝的权限
     * @return 提示内容
     */
    public static String getMessageContent(List<String> permissions){
        StringBuilder messageContent = new StringBuilder("应用需要以下权限才能正常运行\n");
        for (int i = 0 ;i < permissions.size() ; i++){
            messageContent.append((i + 1) + "." + getPermissionExplain(permissions.get(i)) + "\n");
        }
        return messageContent.toString();
    }

    /**
     * 根据权限获取解释说明
     * @param permission  权限
     * @return 解释
     */
    public static String getPermissionExplain(String permission){
        String permissionExplain = "";
        if (DangerousPermissions.ACCESS_COARSE_LOCATION.equals(permission)){
            permissionExplain =  "定位的权限";
        }
//        if (DangerousPermissions.READ_PHONE_STATE.equals(permission)){
//            permissionExplain =  "访问手机信息的权限";
//        }
        if (DangerousPermissions.READ_EXTERNAL_STORAGE.equals(permission)){
            permissionExplain =  "访问存储卡的权限(读)";
        }
        if (DangerousPermissions.WRITE_EXTERNAL_STORAGE.equals(permission)){
            permissionExplain =  "访问存储卡的权限(写)";
        }
        if (DangerousPermissions.CALL_PHONE.equals(permission)){
            permissionExplain =  "拨打电话的权限";
        }
        if (DangerousPermissions.CAMERA.equals(permission)){
            permissionExplain =  "使用摄像头的权限";
        }
        if (DangerousPermissions.RECORD_AUDIO.equals(permission)){
            permissionExplain =  "使用麦克风的权限";
        }
        return permissionExplain;
    }

    /**
     * 处理请求权限结果，接手activity#onRequestPermissionsResult方法功能
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    public static void onRequestPermissionsResult(Activity activity, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        List<String> deniedPermissions = new ArrayList<>();
        for (int i = 0 ; i < permissions.length ; i++){
            if (grantResults[i] == PackageManager.PERMISSION_DENIED){
                deniedPermissions.add(permissions[i]);
            }
        }
        if (deniedPermissions.size() > 0){
            PermissionUtils.handleDeniedPermissions(activity,deniedPermissions,requestCode);
        }
    }
}
