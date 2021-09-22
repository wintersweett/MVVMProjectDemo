package com.mvvm.mvvmprojectdemo;
import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.mvvm.base.activity.BaseActivity;
import com.mvvm.base.utils.Constance;
import com.mvvm.base.viewmodel.BaseViewModel;
import com.mvvm.mvvmprojectdemo.databinding.ActivityMainBinding;

@Route(path = Constance.SPLASH_ACTIVITY)
public class SplashActivity extends BaseActivity<ActivityMainBinding, BaseViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void onRetryBtnClick() {

    }

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected void setDataBindingVariables() {
        super.setDataBindingVariables();
        viewDataBinding.setActivitySplash(this);
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
    public void doClick(View view){
        if(view == viewDataBinding.tvJump){

            ARouter.getInstance().build(Constance.LOGIN_ACTIVITY).navigation();
        }

    }
}