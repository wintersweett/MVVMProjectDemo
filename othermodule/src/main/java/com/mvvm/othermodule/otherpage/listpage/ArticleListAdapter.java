package com.mvvm.othermodule.otherpage.listpage;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mvvm.base.customview.BaseCustomViewModel;
import com.mvvm.base.recyclerview.BaseViewHolder;

import java.util.List;

public class ArticleListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    List<BaseCustomViewModel> mItems ;
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemArticleView view = new ItemArticleView(viewGroup.getContext());
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        if(mItems != null && mItems.size() > 0){
            return mItems.size() ;
        }
        return 0;
    }
    public void setData(List<BaseCustomViewModel> list){
        this.mItems = list ;
        notifyDataSetChanged();
    }
}
