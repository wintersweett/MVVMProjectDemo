package com.mvvm.base.utils;

import android.Manifest;

/**
 * @author : WinterSweett
 * @time : {DATE}
 * 用于保存用户是否拒绝了
 */
public class PermissionConstant {
    public static final String PERMISSION_LOCATION = "permission_location";
    public static final String PERMISSION_SDCARD = "permission_sdcard";
    public static final int PERMISSION_SDCARD_INT = 0x1115;
    public static final String PERMISSION_SDCARD_CAMERA = "permission_sdcard_camera";
    public static final int PERMISSION_SDCARD_CAMERA_INT = 0x1113;
    public static final String PERMISSION_CAMERA = "permission_camera";
    public static final int PERMISSION_CAMERA_INT = 0x1114;


    //框架的requestCode
    public static final String REQUEST_CODE_PERMISSION_DENIED = "request_code_permission_denied";
    public static final String REQUEST_CODE_PERMISSION_GRANTED = "request_code_permission_granted";
    //上传身份证页面的
    public static final int REQUEST_CODE_CAMERA_SDCARD_FRONT = 333;
    public static final int REQUEST_CODE_CAMERA_SDCARD_BACK = 334;
    public static final int REQUEST_CODE_CAMERA_SDCARD = 335;
    //驾驶证
    public static final int REQUEST_CODE_CAMERA_SDCARD_DRIVE = 336;
    //电话权限组
    public static final int REQUEST_CODE_PHONE = 337;
    //DemoMainActivity中权限
    public static final int REQUEST_CODE_NAVI = 338;






}
