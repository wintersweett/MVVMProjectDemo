package com.mvvm.othermodule.otherpage.listpage;


import android.os.Bundle;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.othermodule.R;
import com.example.othermodule.databinding.ActivityArticleListBinding;
import com.mvvm.base.activity.BaseActivity;
import com.mvvm.base.customview.BaseCustomViewModel;
import com.mvvm.base.utils.Constance;
import com.mvvm.base.viewmodel.BaseViewModel;
import com.mvvm.base.viewmodel.ViewStatus;

import java.util.List;

/***
*@Author: WinterSweett
*@Description:文章列表页面
*/
@Route(path = Constance.ARTICLE_LIST_ACTIVITY)
public class ArticleListActivity extends BaseActivity<ActivityArticleListBinding, BaseViewModel> {
    ArticleListViewModel viewModel ;
    ArticleListAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        getDataFromViewModel();

    }

    private void getDataFromViewModel() {
        viewModel.dataList.observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                List<BaseCustomViewModel> list = (List<BaseCustomViewModel>) o;
                adapter.setData(list);
                cancelDia(ArticleListActivity.this);

            }
        });
    }

    private void initData() {
        showDia(ArticleListActivity.this);
        adapter = new ArticleListAdapter();
        viewDataBinding.rcv.setLayoutManager(new LinearLayoutManager(this));
        viewDataBinding.rcv.setAdapter(adapter);
    }

    @Override
    protected void onRetryBtnClick() {

    }

    @Override
    protected BaseViewModel getViewModel() {
        if(viewModel == null){
            viewModel = ViewModelProviders.of(this).get(ArticleListViewModel.class);
        }
        return viewModel;
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_article_list;
    }
}