package com.mvvm.net.observer;


import com.mvvm.base.model.BaseModel;
import com.mvvm.base.model.BaseNetWorkObserver;
import com.mvvm.base.utils.UtilsLog;
import com.mvvm.net.errorhandler.ExceptionHandle;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/
public class BaseObserver<T> implements Observer<T> {
    BaseModel baseModel;
    BaseNetWorkObserver<T> baseNetWorkObserver;
    public BaseObserver(BaseModel baseModel, BaseNetWorkObserver<T> baseNetWorkObserver) {
        this.baseModel = baseModel;
        this.baseNetWorkObserver = baseNetWorkObserver;
        UtilsLog.d("zhm","baseModel:"+baseModel+" baseNetWorkObserver:"+baseNetWorkObserver);
    }
    @Override
    public void onError(Throwable e) {
        UtilsLog.d("zhm","throwable : "+e);
        if(e instanceof ExceptionHandle.ResponeThrowableException){
            baseNetWorkObserver.onFailure(e);
        } else {
            baseNetWorkObserver.onFailure(new ExceptionHandle.ResponeThrowableException(e, ExceptionHandle.ERROR.UNKNOWN));
        }
    }

    @Override
    public void onNext(T t) {
        baseNetWorkObserver.onSuccess(t, false);
    }

    @Override
    public void onSubscribe(Disposable d) {
        if(baseModel != null){
            baseModel.addDisposable(d);
        }
    }

    @Override
    public void onComplete() {
        UtilsLog.d("zhm","onComplete ");
    }
}
