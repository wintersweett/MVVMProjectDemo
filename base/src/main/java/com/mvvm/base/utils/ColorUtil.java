package com.mvvm.base.utils;
/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/
public class ColorUtil {
    String key = ",";


    /**
     * rgba  ===》argb
     */


    /**
     * 十六进制 转为rgb
     * @param color
     * @param transparency 透明度
     * @return
     */
    public static String getRgba(String color , String transparency){
        int uColor = Integer.parseInt(color,16) ;
        int r = (uColor >>16) &0xFF ;
        int g = (uColor >> 8) &0xFF;
        int b = (uColor) & 0xFF ;
        String rgba = "rgba("+r+","+g+","+b+","+transparency+")";
        return rgba;
    }

    /**
     * rgba--》16进制颜色
     * @param color
     * @return
     */
    public static String getColor16code(String color){
        color = color.substring(5,color.length()-1);
        String[] uColor = color.split(",");
        for(int i =0 ; i< uColor.length ; i++){
            uColor[i]=uColor[i].trim();
        }
        int r = Integer.parseInt(uColor[0]);
        int g = Integer.parseInt(uColor[1]);
        int b =Integer.parseInt(uColor[2]);
        Double a =1.0;
        if(color.split(",").length == 4){
            a = Double.parseDouble(uColor[3]);
        }
        String result = Integer.toHexString(r<<16|g<<8|b).toString();
        return result;
    }

   public static Integer[] getRgbFromRgba(String color){
       color = color.substring(5,color.length()-1);
       String[] uColor = color.split(",");
       for(int i =0 ; i< uColor.length ; i++){
           uColor[i]=uColor[i].trim();
       }
       int r = Integer.parseInt(uColor[0]);
       int g = Integer.parseInt(uColor[1]);
       int b =Integer.parseInt(uColor[2]);
       Integer [] res = new Integer[3];
       res[0] = r;
       res[1]=g;
       res[2] = b;
       return res;

   }
}
