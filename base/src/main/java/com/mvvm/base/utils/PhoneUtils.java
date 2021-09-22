package com.mvvm.base.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class PhoneUtils {
    public static void dialPhone(Context mContext, String phone) {
        String action = Intent.ACTION_DIAL;// 显示拨号界面
        if (StringUtils.isNullOrEmpty(phone)) {
            return;
        }
        Intent intent = new Intent(action, Uri.parse("tel:" + phone));
        mContext.startActivity(intent);
    }}
