package com.mvvm.common.views;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;


import androidx.recyclerview.widget.RecyclerView;

import com.mvvm.common.R;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class PopupWindowCarArea extends PopupWindow {
    public RecyclerView recyclerView ;
    public PopupWindowCarArea(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.pup_car_area,null) ;
        this.setContentView(view);
        this.setWidth(LayoutParams.MATCH_PARENT);
        this.setHeight(LayoutParams.WRAP_CONTENT);
        ColorDrawable drawable = new ColorDrawable(0xb0000000) ;
        this.setBackgroundDrawable(drawable);

        recyclerView = view.findViewById(R.id.rcv);
    }
}
