package com.mvvm.common.views;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.mvvm.common.R;

/**
 * @author : WinterSweett
 * @time : {DATE}
 * 选择pic的弹窗
 */
public class TakePhotoPopupWindow extends PopupWindow {
    public ImageView ivFinish;
    public RecyclerView rcv;
    public TextView tv_give_back_car;
    public RelativeLayout rl_photo,rl_camera;

    public TakePhotoPopupWindow(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.popup_window_take_photo, null);
        ivFinish = view.findViewById(R.id.iv_finish);
        tv_give_back_car = view.findViewById(R.id.tv_give_back_car);
        rl_photo = view.findViewById(R.id.rl_photo);
        rl_camera = view.findViewById(R.id.rl_camera);
        this.setContentView(view);
        this.setWidth(LayoutParams.MATCH_PARENT);
        this.setHeight(LayoutParams.WRAP_CONTENT);
        ColorDrawable drawable = new ColorDrawable(0xb0000000);
        this.setBackgroundDrawable(drawable);
    }
}
