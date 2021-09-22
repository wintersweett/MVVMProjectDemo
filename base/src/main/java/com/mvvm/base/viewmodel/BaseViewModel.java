package com.mvvm.base.viewmodel;


import java.util.List;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.mvvm.base.model.BaseModel;
import com.mvvm.base.model.IBaseModelListener;
import com.mvvm.base.model.PagingResult;
import com.mvvm.base.utils.AppManager;
import com.mvvm.base.utils.UtilsLog;

/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/
public abstract class BaseViewModel<M extends BaseModel, D> extends ViewModel implements LifecycleObserver, IBaseModelListener<List<D>> {
    protected M model;
    public MutableLiveData<List<D>> dataList = new MutableLiveData();
    public MutableLiveData<ViewStatus> viewStatusLiveData = new MutableLiveData();
    public MutableLiveData<String> errorMessage = new MutableLiveData();
    public static  String TAG = "";
    public BaseViewModel() {
        TAG = getClass().getSimpleName() ;
        UtilsLog.d(TAG,TAG);
        dataList.setValue(new ObservableArrayList<>());
        viewStatusLiveData.setValue(ViewStatus.LOADING);
        errorMessage.setValue("");
    }

    public void tryToRefresh() {
        if (model != null) {
            model.refresh();
        }
    }

    public void tryToLoadNextPage() {
        if(model != null){
            model.load();
        }
    }

    @Override
    protected void onCleared() {
        if (model != null) {
            model.cancel();
        }
    }

    @Override
    public void onLoadFinish(BaseModel model, List<D> data, PagingResult... pagingResult) {
            if (model.isPaging()) {
                if (pagingResult[0].isFirstPage) {
                    dataList.getValue().clear();
                }
                if (pagingResult[0].isEmpty) {
                    if (pagingResult[0].isFirstPage) {
                        viewStatusLiveData.setValue(ViewStatus.EMPTY);
                    } else {
                        viewStatusLiveData.setValue(ViewStatus.NO_MORE_DATA);
                    }
                } else {
                    if(pagingResult[0].isFirstPage){
                        dataList.postValue(data);
                    }else {
                        dataList.getValue().addAll(data);
                        dataList.postValue(dataList.getValue());
                    }

                    viewStatusLiveData.setValue(ViewStatus.SHOW_CONTENT);
                }
            } else {
                dataList.getValue().clear();
                dataList.getValue().addAll(data);
                dataList.postValue(dataList.getValue());
                viewStatusLiveData.setValue(ViewStatus.SHOW_CONTENT);
            }
            viewStatusLiveData.postValue(viewStatusLiveData.getValue());
    }

    @Override
    public void onLoadFail(BaseModel model, String prompt, PagingResult... pagingResult) {
        errorMessage.setValue(prompt);
        if(model.isPaging() && !pagingResult[0].isFirstPage) {
            viewStatusLiveData.setValue(ViewStatus.LOAD_MORE_FAILED);
        } else {
            viewStatusLiveData.setValue(ViewStatus.REFRESH_ERROR);
        }
        viewStatusLiveData.postValue(viewStatusLiveData.getValue());
    }
/**
 * @param:
*一个观察者，当执行到某个生命周期时，会通知观察者执行对应的方法
*/
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume() {
        dataList.postValue(dataList.getValue());
        viewStatusLiveData.postValue(viewStatusLiveData.getValue());
        UtilsLog.d("zhm","BaseViewModel onResum "+getClass().getSimpleName());
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        UtilsLog.d("zhm", " BaseViewModel onCreate: "+getClass().getSimpleName()+"  viewmodel "+this);
        AppManager.getInstance().addViewModel(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        UtilsLog.d("zhm", "BaseViewModel onStart: "+getClass().getSimpleName());
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        UtilsLog.d("zhm", "BaseViewModel onPause: "+getClass().getSimpleName());
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        UtilsLog.d("zhm", "BaseViewModel onStop: "+getClass().getSimpleName());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        UtilsLog.d("zhm", "BaseViewModel onDestroy: "+getClass().getSimpleName()+getClass().getSimpleName());
        AppManager.getInstance().remove(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny() {
        UtilsLog.d("zhm", "BaseViewModel onAny: "+getClass().getSimpleName());
    }


}
