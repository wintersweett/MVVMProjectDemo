package com.mvvm.base.recyclerview;

import android.util.Log;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mvvm.base.customview.BaseCustomViewModel;
import com.mvvm.base.customview.ICustomView;
import com.mvvm.base.utils.UtilsLog;

/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/
public class BaseViewHolder extends RecyclerView.ViewHolder {
    ICustomView view;

    public BaseViewHolder(ICustomView view) {
        super((View) view);
        this.view = view;
        UtilsLog.d("zhm","getAdapterPosition: "+getAdapterPosition()) ;
    }


    public void bind(@NonNull BaseCustomViewModel item) {
        view.setData(item);
    }
}