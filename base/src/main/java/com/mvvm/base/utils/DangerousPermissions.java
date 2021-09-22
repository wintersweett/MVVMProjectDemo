package com.mvvm.base.utils;

import android.Manifest;

public class DangerousPermissions {
    /**允许程序读取用户的日程信息*/
    public static final String READ_CALENDAR = Manifest.permission.READ_CALENDAR;
    /**允许程序写入日程，但不可读取*/
    public static final String WRITE_CALENDER = Manifest.permission.WRITE_CALENDAR;

    /**允许程序访问摄像头进行拍照*/
    public static final String CAMERA = Manifest.permission.CAMERA;

    /**写入联系人，但不可读取*/
    public static final String WRITE_CONTACTS = Manifest.permission.WRITE_CONTACTS;
    /**允许程序访问账户Gmail列表*/
    public static final String GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS;

    /**	允许程序通过GPS芯片接收卫星的定位信息*/
    public static final String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    /**允许程序通过WiFi或移动基站的方式获取用户错略的经纬度信息*/
    public static final String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;

    /**允许程序录制声音通过手机或耳机的麦克*/
    public static final String RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;

    /**允许程序访问电话状态*/
   // public static final String READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
    /**允许程序从非系统拨号器里拨打电话*/
    public static final String CALL_PHONE = Manifest.permission.CALL_PHONE;
    /**读取通话记录*/
    public static final String READ_CALL_LOG = Manifest.permission.READ_CALL_LOG;
    /**允许程序写入（但是不能读）用户的联系人数据*/
    public static final String WRITE_CALL_LOG = Manifest.permission.WRITE_CALL_LOG;
    /**允许一个应用程序添加语音邮件系统*/
    public static final String ADD_VOICEMAIL = Manifest.permission.ADD_VOICEMAIL;
    /**允许程序使用SIP视频服务*/
    public static final String USE_SIP = Manifest.permission.USE_SIP;
    /**允许程序监视，修改或放弃播出电话*/
    public static final String PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS;

    /**SENSORS 传感器*/
    public static final String BODY_SENSORS = Manifest.permission.BODY_SENSORS;

    /**	允许程序发送短信*/
    public static final String SEND_SMS = Manifest.permission.SEND_SMS;
    /**允许程序接收短信*/
    public static final String RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;
    /**允许程序读取短信内容*/
    public static final String READ_SMS = Manifest.permission.READ_SMS;
    /**允许程序接收WAP PUSH信息*/
    public static final String RECEIVE_WAP_PUSH = Manifest.permission.RECEIVE_WAP_PUSH;
    /**	允许程序接收彩信*/
    public static final String RECEIVE_MMS = Manifest.permission.RECEIVE_MMS;

    /**允许程序读sd卡*/
    public static final String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    /**	允许程序写sd卡*/
    public static final String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;


    /**日历的权限*/
    public static final String CALENDAR = Manifest.permission_group.CALENDAR;
    /**相机的权限*/
    public static final String CAMERA_GROUP = Manifest.permission_group.CAMERA;
    /**联系人的权限*/
    public static final String CONTACTS = Manifest.permission_group.CONTACTS;
    /**位置的权限*/
    public static final String LOCATION = Manifest.permission_group.LOCATION;
    /**麦克风的权限*/
    public static final String MICROPHONE = Manifest.permission_group.MICROPHONE;
    /**手机的权限*/
    public static final String PHONE = Manifest.permission_group.PHONE;
    /**传感器的权限*/
    public static final String SENSORS = Manifest.permission_group.SENSORS;
    /**短信的权限*/
    public static final String SMS = Manifest.permission_group.SMS;
    /**存储卡的权限*/
    public static final String STORAGE = Manifest.permission_group.STORAGE;
}
