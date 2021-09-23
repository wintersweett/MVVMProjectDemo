package com.mvvm.net.model;


import com.mvvm.base.model.BaseModel;
import com.mvvm.base.preference.BasicDataPreferenceUtil;
import com.mvvm.base.utils.ConstantFinal;
import com.mvvm.net.NetWorkApiBase;
import com.mvvm.net.api.RefreshTokenInterface;
import com.mvvm.net.beans.RefreshTokenResponse;
import com.mvvm.net.observer.BaseObserver;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class RefreshTokenModel extends BaseModel<RefreshTokenResponse, RefreshTokenModel.Token> {
    public RefreshTokenModel() {
        super(RefreshTokenResponse.class, false, null, null);
    }
    public class Token {
        public String token ;
        public int statusCode ;
        public String statusMsg ;
    }

    @Override
    public void load() {
        String refreshToken = BasicDataPreferenceUtil.getInstance().getString(ConstantFinal.REFRESH_TOKEN) ;
        NetWorkApiBase.getService(RefreshTokenInterface.class)
                .getToken(refreshToken)
                .compose(NetWorkApiBase.getInstance()
                .applySchedulers(new BaseObserver<RefreshTokenResponse>(this,this))) ;
    }

    @Override
    public void onSuccess(RefreshTokenResponse t, boolean isFromCache) {
        Token  token = new Token();
        if(t.getData()!= null){
            token.token = t.getData().getToken();
        }
        token.statusCode = t.getErrorCode();
        token.statusMsg = t.getErrorMsg();
        notifyResultToListeners(t,token,isFromCache);

    }

    @Override
    public void onFailure(Throwable e) {

    }
}
