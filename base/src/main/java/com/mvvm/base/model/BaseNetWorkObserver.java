package com.mvvm.base.model;

/**
* @author :WinterSweett
 * @description
 *
*/
public interface BaseNetWorkObserver<F> {
    /**
     * @param:
    *加载成功后回调
    */
    void onSuccess(F t, boolean isFromCache);
    void onFailure(Throwable e);
}
