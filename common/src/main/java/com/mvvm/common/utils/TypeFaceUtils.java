package com.mvvm.common.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class TypeFaceUtils {
    public static Typeface initSpecial(Context context,String assessStr){
        AssetManager mgr =context.getAssets();
        Typeface tf = Typeface.createFromAsset(mgr,assessStr);
        return tf;
    }
    public static Typeface initSpecialMedia(Context context){
        AssetManager mgr =context.getAssets();
        Typeface tf = Typeface.createFromAsset(mgr,"fonnts/BarlowCondensed-Medium.ttf");
        return tf ;
    }
    public static Typeface initSpecialRegular(Context context){
        AssetManager mgr =context.getAssets();
        Typeface tf = Typeface.createFromAsset(mgr,"fonnts/BarlowCondensed-Regular.ttf");
        return tf ;
    }
}
