package com.mvvm.common.views;

import android.content.Context;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.mvvm.base.customview.BaseCustomView;
import com.mvvm.base.utils.Constance;
import com.mvvm.common.R;
import com.mvvm.common.databinding.MycardviewBinding;
import com.mvvm.common.viewmodel.MyCardViewModel;

/**
* @author :WinterSweett
 * @description
 *
*/
public class MyCardView extends BaseCustomView<MycardviewBinding, MyCardViewModel> {


    public MyCardView(Context context) {
        super(context);

    }

    @Override
    protected int setViewLayoutId() {
        return R.layout.mycardview;
    }

    @Override
    protected void setDataToView(MyCardViewModel data) {
        getDataBinding().setViewModel(data);

    }

    @Override
    protected void onRootClick(View view) {
//        ARouter.getInstance().build(Constance.WEBACTIVITY)
//                .withString("link",getViewModel().url)
//                .navigation();

        //TODO 暂时 用于长短租入口
        ARouter.getInstance().build(Constance.HOME_OF_RENT_CAR)
                .navigation();



        // TODO  调试 悦行
//        String url = BasicDataPreferenceUtil.getInstance().getString(ConstantFinal.YUEXING_URL);
//        ARouter.getInstance().build(Constance.WAP_BROWSER_COMMON_ACTIVITY)
//                .withString("link",url)
//                .navigation();
    }
}
