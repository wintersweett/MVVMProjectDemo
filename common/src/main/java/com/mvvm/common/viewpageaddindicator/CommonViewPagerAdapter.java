package com.mvvm.common.viewpageaddindicator;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
/**
* @author :WinterSweett
 * @description
 *
*/
public class CommonViewPagerAdapter<T> extends PagerAdapter {
    private List<T> mDatas ;
    private ViewPagerHolderCreator mCreator ;
    public CommonViewPagerAdapter(List<T> datas , ViewPagerHolderCreator creator){
        mDatas = datas;
        mCreator = creator ;

    }
    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public void finishUpdate(@NonNull ViewGroup container) {
        super.finishUpdate(container);

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    //重点在这里，不再把布局血丝，而是用接口提供的布局。 也不在这里绑定数据，数据绑定交给api调用者
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = getView(position,null,container);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    private View getView(int position , View view , ViewGroup container){
        ViewPageHolder holder = null ;
        if(view == null){
            holder = mCreator.createViewHolder();
            view = holder.createView(container.getContext());
        }else {
        }
        if(holder !=null && mDatas != null && mDatas.size() >0){
            //数据绑定
            holder.onBind(container.getContext(),position,mDatas.get(position));
        }
        return view;
    }
}
