package com.mvvm.common.views;

import android.content.Context;
import android.view.View;

import com.mvvm.base.customview.BaseCustomView;
import com.mvvm.base.customview.BaseCustomViewModel;
import com.mvvm.base.utils.StringUtils;
import com.mvvm.common.R;
import com.mvvm.common.databinding.ItemChargelistBinding;
import com.mvvm.common.viewmodel.ItemChargeListViewModel;

/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/
public class MyChargeItemView extends BaseCustomView<ItemChargelistBinding, ItemChargeListViewModel> {
    public interface ItemSelect{
        void onItemClicked(BaseCustomViewModel viewModel);
    }
    private ItemSelect mItemSelect;
    ItemChargeListViewModel viewModel;
    public MyChargeItemView(Context context, ItemSelect itemSelect) {
        super(context);
        mItemSelect = itemSelect;
    }

    @Override
    protected int setViewLayoutId() {
        return R.layout.item_chargelist;
    }

    @Override
    protected void setDataToView(ItemChargeListViewModel data) {
        getDataBinding().setViewModel(data);
        getDataBinding().executePendingBindings();
        if(!StringUtils.isNullOrEmpty(data.label) ){
            getDataBinding().ivGiveHour.setVisibility(View.VISIBLE);
            getDataBinding().ivGiveHour.setBackgroundResource(R.drawable.shape_discount);
            getDataBinding().ivGiveHour.setPadding(8,2,8,2);
        }else {
            getDataBinding().ivGiveHour.setVisibility(View.GONE);
        }
        viewModel = data;
    }


    @Override
    protected void onRootClick(View view) {
        //设置所有item 为false ，单个的为true
        if(mItemSelect!= null) {
            mItemSelect.onItemClicked(getViewModel());
        }

    }
}
