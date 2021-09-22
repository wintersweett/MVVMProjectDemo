package com.mvvm.common.views;

import android.content.Context;
import android.view.View;

import com.mvvm.base.customview.BaseCustomView;
import com.mvvm.common.R;
import com.mvvm.common.databinding.ItemCarAreaBinding;
import com.mvvm.common.viewmodel.ItemCarAreaViewModel;


/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class ItemCarArea extends BaseCustomView<ItemCarAreaBinding, ItemCarAreaViewModel> {
    public ItemCarArea(Context context) {
        super(context);
    }

    @Override
    protected int setViewLayoutId() {
        return R.layout.item_car_area;
    }

    @Override
    protected void setDataToView(ItemCarAreaViewModel data) {
        getDataBinding().setViewModel(data);

    }

    @Override
    protected void onRootClick(View view) {

    }
}
