package com.mvvm.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.mvvm.base.utils.UtilsLog;
import com.mvvm.common.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class ImageUtils {
    public static Bitmap saveImg(Context context , String url){
        final Bitmap[] bitmap = new Bitmap[1];
        Glide.with(context).asBitmap().load(url)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        bitmap[0] = resource ;
                    }
                });
        return bitmap[0];
    }

    public static void showBackImg(Context context , String url, View view){
        //设置图片圆角角度
      //  RoundedCorners roundedCorners= new RoundedCorners(15);
//通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.back_default) ;
        Glide.with(view.getContext())
                .asBitmap()
                .load(url)
                .apply(options)
              //  .apply(RequestOptions.bitmapTransform(roundedCorners))
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        Drawable drawable = new BitmapDrawable(resource);
                        view.setBackground(drawable);
                    }

                });

    }
    public static void showBackImgNo(Context context , String url, View view){
        //设置图片圆角角度
        //  RoundedCorners roundedCorners= new RoundedCorners(15);
//通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.back_default) ;
        Glide.with(view.getContext())
                .asBitmap()
                .load(url)
                .apply(options)
                //  .apply(RequestOptions.bitmapTransform(roundedCorners))
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        int imageWidth = resource.getWidth() ;
                        int imageHeight = resource.getHeight() ;
                        int height = ScreenUtils.getScreenWidth()*imageHeight/imageWidth;
                        ViewGroup.LayoutParams params = view.getLayoutParams();
                        params.height = height ;
                        params.width = ScreenUtils.getScreenWidth();
                       int dipHeight = DisplayMetricsUtils.px2dip(view.getContext(),height);
                        Drawable drawable = new BitmapDrawable(resource);
                        view.setBackground(drawable);
                    }
                });

    }


    public static void showLeftViewImg(Context context , String url, ImageView view){
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.usecar) ;
        Glide.with(view.getContext())
                .asBitmap()
                .load(url)
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .apply(options)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        int imageWidth = resource.getWidth() ;
                        int imageHeight = resource.getHeight() ;
                        int height = ScreenUtils.getScreenWidth()*imageHeight/imageWidth;
                        ViewGroup.LayoutParams params = view.getLayoutParams();
                        params.height = height ;
                        params.width = ScreenUtils.getScreenWidth();
                        view.setImageBitmap(resource);
                    }
                });

    }
    public static void showViewImgCenterCrop(Context context , String url, ImageView view){
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.usecar) ;
        Glide.with(view.getContext())
                .asBitmap()
                .load(url)
                .apply(options)
                .into(view);

    }
    public static void showViewImg(Context context , String url, ImageView view){
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.usecar) ;

        Glide.with(view.getContext())
                .asBitmap()
                .load(url)
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .apply(options)
                .into(view);

    }
}
