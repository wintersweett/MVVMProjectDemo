package com.mvvm.common.views;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.mvvm.common.R;

/**
 * @author : WinterSweett
 * @time : {DATE}
 * 还车弹窗
 */
public class MyPopupWindow extends PopupWindow {
    public ImageView ivFinish;
    public RecyclerView rcv;
    public TextView tv_give_back_car ; //还车按钮
    public MyPopupWindow(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.popupwindow_my,null) ;
        ivFinish = view.findViewById(R.id.iv_finish) ;
        rcv = view.findViewById(R.id.rcv) ;
        tv_give_back_car = view.findViewById(R.id.tv_give_back_car) ;
        this.setContentView(view);
        this.setWidth(LayoutParams.MATCH_PARENT);
        this.setHeight(LayoutParams.WRAP_CONTENT);
        ColorDrawable drawable = new ColorDrawable(0xb0000000) ;
        this.setBackgroundDrawable(drawable);
    }

}
