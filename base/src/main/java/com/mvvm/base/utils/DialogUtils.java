package com.mvvm.base.utils;

import android.app.Dialog;
import android.content.Context;

import com.mvvm.base.R;


/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class DialogUtils {
    public static Dialog showProcessDialog(Context context){
        Dialog customDialog = new Dialog(context, R.style.Base_V7_Theme_AppCompat_Dialog) ;
        customDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        customDialog.setContentView(R.layout.process_dialog);
        customDialog.show();
        customDialog.setCanceledOnTouchOutside(false);
        return customDialog;
    }


}
