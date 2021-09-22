package com.mvvm.login.login;

import androidx.lifecycle.MutableLiveData;

import com.mvvm.base.model.BaseModel;
import com.mvvm.base.model.IBaseModelListener;
import com.mvvm.base.model.PagingResult;
import com.mvvm.base.utils.UtilsLog;
import com.mvvm.base.viewmodel.BaseViewModel;
import com.mvvm.login.beans.LoginResult;

public class LoginActivityViewModel extends BaseViewModel {

    IBaseModelListener listener = new IBaseModelListener() {
        @Override
        public void onLoadFinish(BaseModel model, Object data, PagingResult... pageResult) {
            if(model instanceof LoginModel){
                LoginResult result = (LoginResult) data;
                resultMutableLiveData.setValue(result);
            }
        }

        @Override
        public void onLoadFail(BaseModel model, String prompt, PagingResult... pageResult) {
            UtilsLog.d(TAG,"model::"+model+"  prompt::"+prompt);

        }
    };

    BaseModel loginModel ;
    public MutableLiveData<LoginResult> resultMutableLiveData = new MutableLiveData<>();
    public void login(){
        loginModel = new LoginModel();
        loginModel.register(listener);
        loginModel.getCachedDataAndLoad();
    }
}
