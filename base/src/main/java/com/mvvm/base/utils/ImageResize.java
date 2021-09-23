package com.mvvm.base.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class ImageResize {
    public static Bitmap resizeBitmap(Context context, InputStream inputStream, int maxW, int maxH, boolean hasAlpha) {
        Resources resources = context.getResources();
        BitmapFactory.Options options = new BitmapFactory.Options();
        //需要拿得到系统处理的信息  比如解码出宽高,....
        options.inJustDecodeBounds = true;
        //我们把原来的解码参数改了再去生成bitmap
        Rect rect = new Rect();
        rect.set(-1,-1,-1,-1);
       // BitmapFactory.decodeStream(inputStream,new Rect(),options);
        //取到宽高
        int w = options.outWidth;
        int h = options.outHeight;
        //设置缩放系数
        options.inSampleSize = calcuteInSampleSize(w, h, maxW, maxH);

        if(!hasAlpha){
            options.inPreferredConfig=Bitmap.Config.RGB_565;
        }
        options.inJustDecodeBounds=false;
        return BitmapFactory.decodeStream(inputStream,rect,options);

    }

    //返回结果是原来解码的图片的大小  是我们需要的大小的   最接近2的几次方倍
    public static int calcuteInSampleSize(int w, int h, int maxW, int maxH) {
        int inSampleSize = 1;
        if (w > maxW && h > maxH) {
            inSampleSize = 2;
            while (w / inSampleSize > maxW && h / inSampleSize > maxH){
                inSampleSize*=2;
            }
        }
        inSampleSize/=2;
        return inSampleSize;
    }


    /**
     * 质量压缩,把压缩后的bitmap写入file中
     * (质量压缩不会压缩bitmap的大小,只会更改磁盘大小)
     *
     * @param bitmap
     * @param file
     * @return
     */
    public static File updateFile(Bitmap bitmap, File file) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            //把压缩后的数据baos存放到ByteArrayInputStream中
            InputStream inputStream = new ByteArrayInputStream(baos.toByteArray());
            int x;
            byte[] b = new byte[1024 * 100];
            while ((x = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, x);
            }
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return file;
    }
}








