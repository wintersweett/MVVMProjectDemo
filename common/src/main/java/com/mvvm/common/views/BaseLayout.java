package com.mvvm.common.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mvvm.base.utils.StringUtils;
import com.mvvm.common.R;


public class BaseLayout extends RelativeLayout {

    public View ll_header_right_middle;
    private TextView tv_header, tv_header_left, tv_header_right, tv_header_right_middle;
    public View header_bar, ll_header_left, ll_header_right;
    public ImageView iv_header_left;
    public LinearLayout parent_ll;
    public ImageView im_mRight,im_mRight2;//标题栏右侧自定义图标
    public TextView line_header;
    public BaseLayout(Context context, int layoutResourceId) {
//        super(context);
//        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        header_bar = layoutInflater.inflate(R.layout.header, null);
//        header_bar.setId(R.id.header_bar);
//        im_mRight = (ImageView) header_bar.findViewById(R.id.im_mRight);
//        im_mRight2= (ImageView) header_bar.findViewById(R.id.im_mRight2);
//        im_mRight.setVisibility(View.GONE);
//        im_mRight2.setVisibility(View.GONE);
//        ll_header_left = header_bar.findViewById(R.id.ll_header_left);
//        ll_header_right = header_bar.findViewById(R.id.ll_header_right);
//        ll_header_right_middle = header_bar.findViewById(R.id.ll_header_right_middle);
//        parent_ll = (LinearLayout) header_bar.findViewById(R.id.header_bar);
//        tv_header_right = (TextView) header_bar.findViewById(R.id.tv_header_right);
//        tv_header_right_middle = (TextView) header_bar.findViewById(R.id.tv_header_right_middle);
//        tv_header_left = (TextView) header_bar.findViewById(R.id.tv_header_left);
//        iv_header_left = (ImageView) header_bar.findViewById(R.id.iv_header_left);
//        tv_header = (TextView) header_bar.findViewById(R.id.tv_header_middle);
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
//        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//        addView(header_bar, params);
//        View view = layoutInflater.inflate(layoutResourceId, null);
//        params = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
//        params.addRule(RelativeLayout.BELOW, R.id.header_bar);
//        addView(view, params);
//        ll_header_left.setVisibility(View.VISIBLE);
//        iv_header_left.setVisibility(View.VISIBLE);
        this(context,layoutResourceId,true);//蓝色的头暂时不用，替换为白色
    }
    public BaseLayout(Context context, int layoutResourceId , boolean isCloudStyle) {
        super(context);
        if (isCloudStyle) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            header_bar = layoutInflater.inflate(R.layout.header_cloud_style, null);
            header_bar.setId(R.id.header_bar);
            im_mRight = (ImageView) header_bar.findViewById(R.id.im_mRight);
            im_mRight2= (ImageView) header_bar.findViewById(R.id.im_mRight2);
            im_mRight.setVisibility(View.GONE);
            im_mRight2.setVisibility(View.GONE);
            ll_header_left = header_bar.findViewById(R.id.ll_header_left);
            ll_header_right = header_bar.findViewById(R.id.ll_header_right);
            ll_header_right_middle = header_bar.findViewById(R.id.ll_header_right_middle);
            parent_ll = (LinearLayout) header_bar.findViewById(R.id.header_bar);
            tv_header_right = (TextView) header_bar.findViewById(R.id.tv_header_right);
            tv_header_right_middle = (TextView) header_bar.findViewById(R.id.tv_header_right_middle);
            tv_header_left = (TextView) header_bar.findViewById(R.id.tv_header_left);
            iv_header_left = (ImageView) header_bar.findViewById(R.id.iv_header_left);
            tv_header = (TextView) header_bar.findViewById(R.id.tv_header_middle);
            line_header = (TextView) header_bar.findViewById(R.id.line_header);
            LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            addView(header_bar, params);
            View view = layoutInflater.inflate(layoutResourceId, null);
            params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
            params.addRule(RelativeLayout.BELOW, R.id.header_bar);
            addView(view, params);
            ll_header_left.setVisibility(View.VISIBLE);
            iv_header_left.setVisibility(View.VISIBLE);
        }
    }

    public void setmRight(int id,int id2) {
        im_mRight.setVisibility(View.VISIBLE);
        im_mRight.setBackgroundResource(id);
        if(id2 != 0){
            im_mRight2.setVisibility(View.VISIBLE);
            im_mRight2.setBackgroundResource(id2);
        }else {
            im_mRight2.setVisibility(View.GONE);
        }
    }

    public void setTitle(String title) {
        if (title != null) {
            tv_header.setVisibility(View.VISIBLE);
            tv_header.setText(title);
        } else {
            tv_header.setVisibility(View.GONE);
        }
    }

    public void setLeft(String left) {
        if (StringUtils.isNullOrEmpty(left)) {
            ll_header_left.setVisibility(View.GONE);
        } else {
            ll_header_left.setVisibility(View.VISIBLE);
            tv_header_left.setText(left);
            tv_header_left.setVisibility(View.VISIBLE);
            iv_header_left.setVisibility(View.GONE);
        }
    }
    public void setLeft(String left,int resId) {
        ll_header_left.setVisibility(View.VISIBLE);
        if (!StringUtils.isNullOrEmpty(left)){
            tv_header_left.setVisibility(View.VISIBLE);
            tv_header_left.setText(left);
        }else{
            tv_header_left.setVisibility(View.GONE);
        }
        iv_header_left.setVisibility(View.VISIBLE);
        iv_header_left.setImageResource(resId);
    }
    public void setRight1(String title) {
        if (title != null) {
            ll_header_right.setVisibility(View.VISIBLE);
            tv_header_right.setVisibility(View.VISIBLE);
            tv_header_right.setText(title);
        } else {
            ll_header_right.setVisibility(View.GONE);
            tv_header_right.setVisibility(View.GONE);
        }
    }

    public void hideHeaderLine(){
        if (line_header != null) {
            line_header.setVisibility(GONE);
        }
    }

    /**
     * 右上角为图片,文本为空
     */
    public void setRight1Drawable(int id) {
        Drawable drawable = getResources().getDrawable(id);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tv_header_right.setCompoundDrawables(null, null, drawable, null);
        ll_header_right.setVisibility(View.VISIBLE);
        tv_header_right.setVisibility(View.VISIBLE);
        tv_header_right.setGravity(Gravity.CENTER);
        tv_header_right.setPadding(32, 0, 32, 0);
        tv_header_right.setText("");
    }

    /**
     * 右上角右侧第二位置为图片,文本为空
     */
    public void setRightMiddleDrawable(int id) {
        Drawable drawable = getResources().getDrawable(id);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tv_header_right_middle.setCompoundDrawables(null, null, drawable, null);
        ll_header_right_middle.setVisibility(View.VISIBLE);
        tv_header_right_middle.setVisibility(View.VISIBLE);
        tv_header_right_middle.setGravity(Gravity.CENTER);
        tv_header_right_middle.setPadding(32, 0, 32, 0);
        tv_header_right_middle.setText("");
    }

    /**
     * 仅显示中间图片 不显示右边图片
     */
    public void setShowMiddleDrawable(int id) {
        Drawable drawable = getResources().getDrawable(id);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tv_header_right_middle.setCompoundDrawables(null, null, drawable, null);
        ll_header_right_middle.setVisibility(View.VISIBLE);
        tv_header_right_middle.setVisibility(View.VISIBLE);
        tv_header_right_middle.setGravity(Gravity.CENTER);
        tv_header_right_middle.setPadding(32, 0, 32, 0);
        tv_header_right_middle.setText("");
//        tv_header_right.setCompoundDrawables(null, null, null, null);
        ll_header_right.setVisibility(View.VISIBLE);
        tv_header_right.setVisibility(View.VISIBLE);
        tv_header_right.setGravity(Gravity.CENTER);
        tv_header_right.setText("");
    }

    /**
     * 设置右上角的文字颜色
     *
     * @param color
     */
    public void setRight1TextColor(int color) {
        tv_header_right.setTextColor(color);
    }
}
