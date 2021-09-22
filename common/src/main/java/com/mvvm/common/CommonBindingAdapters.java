package com.mvvm.common;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.mvvm.base.utils.StringUtils;
import com.mvvm.base.utils.UtilsLog;
import com.mvvm.common.utils.GlideRatioScalTransForm;

import androidx.databinding.BindingAdapter;

/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/
/**
 */
public class CommonBindingAdapters {

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String url) {
        if(!TextUtils.isEmpty(url)) {
            Glide.with(view.getContext())
                    .asBitmap()
                    .load(url)
                    .into(new GlideRatioScalTransForm(view));
        }
    }
    @BindingAdapter("android:visibility")
    public static void setVisibility(View view, Boolean value) {
        view.setVisibility(value ? View.VISIBLE : View.GONE);
    }
    @BindingAdapter("updateBackground")
    public static void showBackGround(View view , boolean isSelect){
        if(isSelect){
            view.setBackgroundResource(R.drawable.rl_shape);
        }else{
            view.setBackgroundResource(R.drawable.rl_shape_unselected);
        }
    }

    @BindingAdapter("plateNumUpdateBack")
    public static void showPlateNumBackGround(View view , boolean isSelect){
        if(isSelect){
            view.setBackgroundResource(R.drawable.shape_green_num);
        }else{
            view.setBackgroundResource(R.drawable.shape_gray_num);
        }
    }

    //开发票的多选框
    @BindingAdapter("updateCheckBox")
    public static void showUpdateCheck(View view , boolean isSelect){
        if(isSelect){
            view.setBackgroundResource(R.drawable.invoice_checked);
        }else {
            view.setBackgroundResource(R.drawable.invoice_unchecked);
        }
    }

    //确认订单的多选
    @BindingAdapter("verifyCheckBox")
    public static void showVerifyCheckBox(View view , boolean isSelect){
        if(isSelect){
            view.setBackgroundResource(R.mipmap.verify_check_true);
        }else {
            view.setBackgroundResource(R.mipmap.verify_check_false);
        }
    }

    @BindingAdapter("updateRentBack")
    public static void showUpdateRentBack(View view ,String url){
        if(!StringUtils.isNullOrEmpty(url)){
            RequestOptions options = new RequestOptions()
                    .placeholder(R.drawable.back_default) ;
            Glide.with(view.getContext())
                    .asBitmap()
                    .load(url)
                    .apply(options)
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                            UtilsLog.d("zhm","backImage 2"+resource);
                            Drawable drawable = new BitmapDrawable(resource);
                            view.setBackground(drawable);
                        }

                    });
        }


    }
    /**
     * @param:
    *轮播背景
    */
    @BindingAdapter("updateRecommenCarRentBack")
    public static void showRecommenCarUpdateRentBack(View view ,String url){
        if(!StringUtils.isNullOrEmpty(url)){
            RequestOptions options = new RequestOptions()
                    .placeholder(R.drawable.usecarbackground) ;
            Glide.with(view.getContext())
                    .asBitmap()
                    .load(url)
                    .apply(options)
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                            UtilsLog.d("zhm","backImage 2"+resource);
                            Drawable drawable = new BitmapDrawable(resource);
                            view.setBackground(drawable);
                        }

                    });
        }


    }
    @BindingAdapter("rentImageUrl")
    public static void loadRentImage(ImageView view, String url) {
        if(!TextUtils.isEmpty(url)) {
            RequestOptions options = new RequestOptions()
                    .placeholder(R.drawable.usecar) ;
            Glide.with(view.getContext())
                    .asBitmap()
                    .load(url)
                    .apply(options)
                    .into(view);
        }

    }

    @BindingAdapter("updateBackGround")
    public static void showPolyBack(View view ,String url){
        if(!StringUtils.isNullOrEmpty(url)){
            RequestOptions options = new RequestOptions()
                    .placeholder(R.drawable.back_default) ;
            Glide.with(view.getContext())
                    .asBitmap()
                    .load(url)
                    .apply(options)
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                            UtilsLog.d("zhm","backImage 2"+resource);
                            Drawable drawable = new BitmapDrawable(resource);
                            view.setBackground(drawable);
                        }

                    });
        }


    }
    @BindingAdapter("showPolyImg")
    public static void showPolyImg(View view ,String url){
        if(!StringUtils.isNullOrEmpty(url)){
            RequestOptions options = new RequestOptions()
                    .placeholder(R.mipmap.item3_car) ;
            Glide.with(view.getContext())
                    .asBitmap()
                    .load(url)
                    .apply(options)
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                            UtilsLog.d("zhm","backImage 2"+resource);
                            Drawable drawable = new BitmapDrawable(resource);
                            view.setBackground(drawable);
                        }

                    });
        }

    }
}
