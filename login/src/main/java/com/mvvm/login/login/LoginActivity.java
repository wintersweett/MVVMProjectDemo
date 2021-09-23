package com.mvvm.login.login;

import android.os.Bundle;
import android.view.View;


import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.mvvm.base.activity.BaseActivity;
import com.mvvm.base.utils.Constance;
import com.mvvm.base.viewmodel.BaseViewModel;
import com.mvvm.login.R;
import com.mvvm.login.beans.LoginResult;
import com.mvvm.login.databinding.ActivityLoginBinding;

@Route(path = Constance.LOGIN_ACTIVITY)
public class LoginActivity extends BaseActivity<ActivityLoginBinding, BaseViewModel> {
    LoginActivityViewModel viewModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.resultMutableLiveData.observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(LoginResult loginResult) {
                cancelDia(LoginActivity.this);
                if(0== loginResult.getErrorCode()){
                    ARouter.getInstance().build(Constance.ARTICLE_LIST_ACTIVITY).navigation();
                }

            }
        });


    }

    @Override
    protected void onRetryBtnClick() {

    }


    @Override
    protected BaseViewModel getViewModel() {
        if(viewModel == null){
            viewModel = ViewModelProviders.of(this).get(LoginActivityViewModel.class);
        }
        return viewModel;
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void setDataBindingVariables() {
        super.setDataBindingVariables();
        viewDataBinding.setLoginActivity(this);

    }
    public void doClick(View view){
        if(view == viewDataBinding.btSubmit){
            showDia(this);
            viewModel.login();
        }
    }
}