package com.mvvm.othermodule.otherpage.listpage;

import com.mvvm.base.customview.BaseCustomViewModel;
import com.mvvm.base.model.BaseModel;
import com.mvvm.net.NetWorkApiBase;
import com.mvvm.net.observer.BaseObserver;
import com.mvvm.othermodule.otherpage.api.ApiInterface2;
import com.mvvm.othermodule.otherpage.beans.Datas;
import com.mvvm.othermodule.otherpage.beans.Root;

import java.util.ArrayList;
import java.util.List;

public class ArticleListModel  extends BaseModel<Root, List<BaseCustomViewModel>> {
    public ArticleListModel() {
        super(Root.class, false, null, null);
    }

    @Override
    public void load() {
        NetWorkApiBase.getService(ApiInterface2.class)
                .getArticleList()
                .compose(NetWorkApiBase.getInstance()
                .applySchedulers(new BaseObserver<>(this,this)));

    }

    @Override
    public void onSuccess(Root t, boolean isFromCache) {
        List<BaseCustomViewModel> list = new ArrayList<>();
        for(Datas datas : t.getData().getDatas()){
            ItemArticleViewModel viewModel = new ItemArticleViewModel();
            viewModel.name = datas.getChapterName() ;
            viewModel.title = datas.getTitle() ;
            viewModel.link = datas.getLink();
            list.add(viewModel);
        }
        notifyResultToListeners(t,list,isFromCache);
    }

    @Override
    public void onFailure(Throwable e) {
        loadFail(e.getMessage());

    }
}
