package com.mvvm.common.views;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Message;
import android.view.View;


import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Random;

import androidx.annotation.NonNull;

import com.mvvm.base.customview.BaseCustomView;
import com.mvvm.base.customview.BaseCustomViewModel;
import com.mvvm.base.utils.DialogUtils;
import com.mvvm.base.utils.UtilsLog;
import com.mvvm.common.R;
import com.mvvm.common.databinding.ItemGiveBackCarBinding;
import com.mvvm.common.viewmodel.ItemGiveBackViewModel;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class ItemGiveBackView extends BaseCustomView<ItemGiveBackCarBinding, ItemGiveBackViewModel> {
    Context mContext ;
    Dialog dialog;
    int count = 0 ;
    android.os.Handler handler = new android.os.Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            getDataBinding().pb.setVisibility(GONE);
            getDataBinding().ivIschecked.setImageResource(R.drawable.pass);
            EventBus.getDefault().postSticky("完成");

        }
    };
    public void showDia(Context context){
        if(dialog == null || !dialog.isShowing()){
            dialog = DialogUtils.showProcessDialog(context);
            dialog.setOnDismissListener(new OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    dialog.dismiss();
                }
            });
        }
    }
    public void cancelDia(Context context){
        if(dialog != null){
            dialog.dismiss();
        }
    }
    private List<BaseCustomViewModel> mItems ;
    public ItemGiveBackView(Context context, List<BaseCustomViewModel> items) {
        super(context);
        mItems = items;
    }

    @Override
    protected int setViewLayoutId() {
        return R.layout.item_give_back_car;
    }

    @Override
    protected void setDataToView(ItemGiveBackViewModel data) {
       // Glide.with(getContext()).load(R.drawable.loading).into(getDataBinding().ivIschecked);
        getDataBinding().setViewModel(data);
        Random random = new Random();
        int randomTime = random.nextInt(1000)+500;
        getDataBinding().pb.setVisibility(VISIBLE);
        handler.sendEmptyMessageDelayed(1,randomTime);


    }

    @Override
    protected void onRootClick(View view) {

    }
}
