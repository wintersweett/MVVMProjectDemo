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

/**
* @date :2020/10/20
* @author :WinterSweett
*/
public abstract class AbstractViewModel <M extends BaseModel, D> extends ViewModel implements LifecycleObserver, IBaseModelListener<D> {
        protected M model;
        public MutableLiveData<List<D>> dataList ;
        public MutableLiveData<ViewStatus> viewStatusLiveData;
        public MutableLiveData<String> errorMessage ;


        public AbstractViewModel() {
            dataList = new MutableLiveData<>();
            viewStatusLiveData = new MutableLiveData<>();
            errorMessage = new MutableLiveData<>();
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
            model.load();
        }

        @Override
        protected void onCleared() {
            if (model != null) {
                model.cancel();
            }
        }

        @Override
        public void onLoadFinish(BaseModel model, D data, PagingResult... pagingResult) {
            if (model == this.model) {
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
                        dataList.getValue().add(data) ;
                        dataList.postValue(dataList.getValue());
                        viewStatusLiveData.setValue(ViewStatus.SHOW_CONTENT);
                    }
                } else {
                    dataList.getValue().clear();
                    dataList.getValue().add(data);
                    dataList.postValue(dataList.getValue());
                    viewStatusLiveData.setValue(ViewStatus.SHOW_CONTENT);
                }
                viewStatusLiveData.postValue(viewStatusLiveData.getValue());
            }
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

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        private void onResume() {
            dataList.postValue(dataList.getValue());
            viewStatusLiveData.postValue(viewStatusLiveData.getValue());
        }
    }
