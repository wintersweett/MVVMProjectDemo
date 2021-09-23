package com.mvvm.othermodule.otherpage.listpage;

import android.content.Context;
import android.view.View;

import com.example.othermodule.R;
import com.example.othermodule.databinding.ItemArticleBinding;
import com.mvvm.base.customview.BaseCustomView;

public class ItemArticleView extends BaseCustomView<ItemArticleBinding,ItemArticleViewModel> {
    public ItemArticleView(Context context) {
        super(context);
    }

    @Override
    protected int setViewLayoutId() {
        return R.layout.item_article;
    }

    @Override
    protected void setDataToView(ItemArticleViewModel data) {
        getDataBinding().setViewModel(data);

    }

    @Override
    protected void onRootClick(View view) {

    }
}
