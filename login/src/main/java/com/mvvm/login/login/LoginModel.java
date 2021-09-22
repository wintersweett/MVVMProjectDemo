package com.mvvm.login.login;

import com.mvvm.base.model.BaseModel;
import com.mvvm.login.api.ApiInterface;
import com.mvvm.login.beans.LoginResult;
import com.mvvm.net.NetWorkApiBase;
import com.mvvm.net.observer.BaseObserver;

public class LoginModel  extends BaseModel<LoginResult, LoginResult> {
    public LoginModel() {
        super(LoginResult.class, false, null, null);
    }

    @Override
    public void load() {
        NetWorkApiBase.getService(ApiInterface.class)
                .login("jun","123456")
                .compose(NetWorkApiBase.getInstance()
                .applySchedulers(new BaseObserver<>(this,this)));

    }

    @Override
    public void onSuccess(LoginResult t, boolean isFromCache) {
        notifyResultToListeners(t,t,isFromCache);
    }

    @Override
    public void onFailure(Throwable e) {
        loadFail(e.getMessage());

    }
}
