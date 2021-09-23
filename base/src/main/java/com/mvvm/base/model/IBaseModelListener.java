package com.mvvm.base.model;

import com.mvvm.base.model.BaseModel;
import com.mvvm.base.model.PagingResult;

/**
* @author :WinterSweett
 * @description
 *
*/
public interface IBaseModelListener<T> {
    //用可变长参数统一分页与不分页的接口
    void onLoadFinish(BaseModel model, T data, PagingResult... pageResult);

    void onLoadFail(BaseModel model, String prompt, PagingResult... pageResult);
}