package com.mvvm.othermodule.otherpage.listpage;

import com.mvvm.base.model.BaseModel;
import com.mvvm.base.viewmodel.BaseViewModel;

public class ArticleListViewModel extends BaseViewModel {
    BaseModel articlModel ;
    public  ArticleListViewModel(){
        articlModel = new ArticleListModel() ;
        articlModel.register(this);
        articlModel.getCachedDataAndLoad();
    }

}
