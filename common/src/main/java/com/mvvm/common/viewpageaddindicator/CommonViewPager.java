package com.mvvm.common.viewpageaddindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.mvvm.common.R;
import com.zhouwei.indicatorview.CircleIndicatorView;

import java.util.List;

import androidx.viewpager.widget.ViewPager;

/**
* @author :WinterSweett
 * @description
 *
*/
public class CommonViewPager<T> extends RelativeLayout {
    private ViewPager mViewPager ;
    private CommonViewPagerAdapter mAdapter ;
    private CircleIndicatorView mCircleIndicatorView ;
    public CommonViewPager(Context context) {
        super(context);
        init ();
    }

    public CommonViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init ();
    }

    public CommonViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init ();
    }

    public CommonViewPager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init ();
    }

    private void init (){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.common_view_pager_layout,this,true);
        mViewPager =(ViewPager)view.findViewById(R.id.common_view_pager);
        mCircleIndicatorView = (CircleIndicatorView) view.findViewById(R.id.common_view_pager_indicator_view);
    }

    /**
     * 设置数据
     * @param data
     * @param creator
     */
    public void setPages(List<T> data, ViewPagerHolderCreator creator){
        mAdapter = new CommonViewPagerAdapter(data,creator);
        mViewPager.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mCircleIndicatorView.setUpWithViewPager(mViewPager);
    }

    public void setCurrentItem(int currentItem,boolean smoothScroll){
        mViewPager.setCurrentItem(currentItem,smoothScroll);
    }
    public void setCurItem(int curItem){
        mViewPager.setCurrentItem(curItem);
    }

    public int getCurrentItem(){
        return mViewPager.getCurrentItem();
    }

    public void setOffscreenPageLimit(int limit){
        mViewPager.setOffscreenPageLimit(limit);
    }

    /**
     * 设置切换动画，see {@link ViewPager#setPageTransformer(boolean, ViewPager.PageTransformer)}
     * @param reverseDrawingOrder
     * @param transformer
     */
    public void setPageTransformer(boolean reverseDrawingOrder, ViewPager.PageTransformer transformer){
        mViewPager.setPageTransformer(reverseDrawingOrder,transformer);
    }

    /**
     * see {@link ViewPager#setPageTransformer(boolean, ViewPager.PageTransformer)}
     * @param reverseDrawingOrder
     * @param transformer
     * @param pageLayerType
     */
    public void setPageTransformer(boolean reverseDrawingOrder, ViewPager.PageTransformer transformer,
                                   int pageLayerType) {
        mViewPager.setPageTransformer(reverseDrawingOrder,transformer,pageLayerType);
    }

    /**
     * see {@link ViewPager#addOnPageChangeListener(ViewPager.OnPageChangeListener)}
     * @param listener
     */
    public void addOnPageChangeListener(ViewPager.OnPageChangeListener listener){
        mViewPager.addOnPageChangeListener(listener);
    }

    /**
     * 设置是否显示Indicator
     * @param visible
     */
    public void setIndicatorVisible(boolean visible){
        if(visible){
            mCircleIndicatorView.setVisibility(VISIBLE);
        }else{
            mCircleIndicatorView.setVisibility(GONE);
        }

    }

    public ViewPager getViewPager() {
        return mViewPager;
    }

}
