package com.mvvm.common.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by user on 2016/7/15.
 */
public class MyScrollView extends ScrollView {

    private OnScrollListener mListener;

    public interface OnScrollListener{
        void onScroll(int scrollY);
    }

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setOnScrollListener(OnScrollListener onScrollListener){
        this.mListener=onScrollListener;
    }
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(mListener !=null){
            mListener.onScroll(t);
        }
    }
}
