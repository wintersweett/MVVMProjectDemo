package com.mvvm.common.utils;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class CMRMBSymbolHelper {
    /**
     * 返回￥
     */
//    val rmbSymbol: String
//    get() = 165.toChar().toString()

   public static String getRmbSymbol(String str){
       char ch = 165;
       String rmb = String.valueOf(ch);
        return rmb;
   }
}
