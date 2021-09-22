package com.mvvm.base.utils;

import android.graphics.Bitmap;
import android.util.Log;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class BitmapUtils {
    /**
     * @param:
    *生成二维码
    */
    public static Bitmap create2DCode(String str){
        //生成二维矩阵,编码时要指定大小,
        //不要生成了图片以后再进行缩放,以防模糊导致识别失败
        try {
            BitMatrix matrix = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, 200, 200);
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            UtilsLog.d("WY+", "宽高为：" + width + "|" + height);
            //  二维矩阵转为一维像素数组（一直横着排）
            int[] pixels = new int[width * height];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (matrix.get(x, y)) {
                        pixels[y * width + x] = 0xff000000;
                    }else {
                        pixels[y * width + x] = 0xffffffff;//新加，不然图片都是黑色的
                    }
                }
            }
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            // 通过像素数组生成bitmap, 具体参考api
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
            return bitmap;
//        } catch (WriterException e) {
//            e.printStackTrace();
        } catch (com.google.zxing.WriterException e) {
            e.printStackTrace();
        }
        return null;
    }

}
