package com.mvvm.othermodule.otherpage;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.othermodule.R;
import com.example.othermodule.databinding.ActivityOtherBinding;
import com.mvvm.base.activity.BaseActivity;
import com.mvvm.base.utils.Constance;
import com.mvvm.base.viewmodel.BaseViewModel;

@Route(path = Constance.OTHER_ACTIVITY)
public class OtherActivity extends BaseActivity<ActivityOtherBinding, BaseViewModel> {

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
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_other;
    }
}