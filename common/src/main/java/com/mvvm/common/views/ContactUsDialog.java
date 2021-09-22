package com.mvvm.common.views;

import android.Manifest.permission;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;

import com.mvvm.base.permission.PermissionManager;
import com.mvvm.base.permission.annotation.IPermission;
import com.mvvm.base.preference.BasicDataPreferenceUtil;
import com.mvvm.base.utils.PermissionConstant;
import com.mvvm.base.utils.ToastUtil;
import com.mvvm.base.utils.UtilsLog;
import com.mvvm.common.R;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class ContactUsDialog extends Dialog {
    String phoneNumer ;
    Context mContext ;
    public ContactUsDialog(@NonNull Context context,String phoneNumer) {
        super(context);
        mContext = context ;
        this.phoneNumer = phoneNumer ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.getDecorView().setPadding(0,0,0,0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = LayoutParams.MATCH_PARENT;
        lp.height = LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        window.setBackgroundDrawable(new ColorDrawable(0x00000000));
        setCanceledOnTouchOutside(true);
        setContentView(R.layout.view_contact_us_dialog);
        TextView number = findViewById(R.id.numer);
        number.setText(phoneNumer);
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCallPhone();

            }
        });
        TextView cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
    @IPermission(PermissionConstant.REQUEST_CODE_PHONE)
    private void getCallPhone(){
        UtilsLog.d("ws","getCallPhone");
        String[] perms = {permission.CALL_PHONE} ;
        if(PermissionManager.hasPermissions((Activity)mContext,perms)){
            UtilsLog.d("ws","getCallPhone同意了");
            callPhone();
        }else {
            int requestCode = BasicDataPreferenceUtil.getInstance().getInt(PermissionConstant.REQUEST_CODE_PERMISSION_DENIED,0);
            if(requestCode == PermissionConstant.REQUEST_CODE_PHONE){
                ToastUtil.show("您拒绝了必要的权限请求，通过 设置-权限管理 开启");
            }else {
                PermissionManager.requestPermissions((Activity)mContext,PermissionConstant.REQUEST_CODE_PHONE,perms);
            }

        }
    }


    private void callPhone() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:"+phoneNumer.replace("-",""));
        intent.setData(data);
        getContext().startActivity(intent);
    }
}
