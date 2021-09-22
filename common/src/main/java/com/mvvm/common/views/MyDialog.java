package com.mvvm.common.views;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.annotation.NonNull;

import com.mvvm.common.R;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class MyDialog extends Dialog {
    public MyDialog(@NonNull Context context) {
        super(context);
    }
    Context context ;
    OnClickListener listener ;
    TextView tv_cancel ;
    public MyDialog(Context context , DialogInterface.OnClickListener listener){
        super(context);
        this.context = context ;
        this.listener = listener ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_my);
        tv_cancel = (TextView)findViewById(R.id.tv_cancel);
        tv_cancel.setOnClickListener((View.OnClickListener) listener);


    }
}
