package com.mvvm.common.views;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;


import com.mvvm.base.customview.BaseCustomView;
import com.mvvm.common.R;
import com.mvvm.common.databinding.ItemDiscountCouponBinding;
import com.mvvm.common.viewmodel.ItemDiscountCouponViewModel;

import org.greenrobot.eventbus.EventBus;

/**
 * @author : WinterSweett
 * @time : {DATE}
 * 优惠券的item
 */
public class ItemDiscountCoupon extends BaseCustomView<ItemDiscountCouponBinding, ItemDiscountCouponViewModel> {
    public ItemDiscountCoupon(Context context) {
        super(context);
        getDataBinding().setItemCouponView(this);
        getDataBinding().executePendingBindings();
        initSpecial();
    }
    public void initSpecial(){
        AssetManager mgr =getContext().getAssets();
        Typeface tf = Typeface.createFromAsset(mgr,"fonnts/BarlowCondensed-Medium.ttf");
        getDataBinding().tvDiscountType.setTypeface(tf);
    }

    @Override
    protected int setViewLayoutId() {
        return R.layout.item_discount_coupon;
    }


    @Override
    protected void setDataToView(ItemDiscountCouponViewModel data) {
        getDataBinding().setViewModel(data);
        //用优惠券
        getDataBinding().tvUse.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(data);

            }
        });

    }
    public void doClick(View view){

        if(view ==getDataBinding().tvRule){
            if(getDataBinding().tvRuleDetail.getVisibility() == GONE){
            getDataBinding().tvRuleDetail.setVisibility(View.VISIBLE);
            }else{
                getDataBinding().tvRuleDetail.setVisibility(View.GONE);
            }
        }

    }


    @Override
    protected void onRootClick(View view) {

    }
}
