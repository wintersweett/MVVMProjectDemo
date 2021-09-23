package com.mvvm.base.utils;

import android.os.Environment;

import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {
    /**
    * @author :WinterSweett
     * @description
     *
    */
    /**
     * 判断是否为空
     *
     * @param text
     * @return
     */
    public static boolean isNullOrEmpty(String text) {
        if (text == null || "".equals(text.trim()) || text.trim().length() == 0
                || "null".equals(text.trim())) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 获取异常的原因
     * @param exc 异常
     * @return 异常的原因
     */

    public static String getCause(Exception exc){
        StringBuffer sb = new StringBuffer();
        sb.append("\r\n");
        sb.append("---------------Exception-------------------");
        sb.append("\r\n");
        Writer writer = new StringWriter();
        PrintWriter pw = new PrintWriter(writer);
        exc.printStackTrace(pw);
        Throwable excCause = exc.getCause();
        while (excCause != null) {
            excCause.printStackTrace(pw);
            excCause = excCause.getCause();
        }
        pw.close();
        String result = writer.toString();
        sb.append(result);
        sb.append("\r\n");
        sb.append("----------------end--------------------");
        sb.append("\r\n");
        return sb.toString();
    }
    /**
     * 将文本内容附加date和uername后写入SD卡文件中
     * @param data 文本内容
     * @param pathName 文件路径名称（不含SD卡路径） 例： /Soufun_Agent/
     * @param fileName 文件名称（含后缀名）   例：  crash.log
     * @param maxFileLength 文件长度（单位：kb，无长度限制请传 -1）   例：  64
     */

    public static synchronized void writeToSDCardPre(String data, String pathName,String fileName,int maxFileLength) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String str = formatter.format(date);
        writeToSDCard(data,pathName,fileName,maxFileLength);
    }
    /**
     * 将文本内容写入SD卡文件中
     * @param data 文本内容
     * @param pathName 文件路径名称（不含SD卡路径） 例： /Soufun_Agent/
     * @param fileName 文件名称（含后缀名）   例：  crash.log
     * @param maxFileLength 文件长度（单位：kb，无长度限制请传 -1）   例：  64
     */
    public static synchronized void writeToSDCard(String data, String pathName,String fileName,int maxFileLength){
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
            UtilsLog.i("TestFile", "SD card is not avaiable/writeable right now.");
            return;
        }
        try {
            String sdcardPath = Environment.getExternalStorageDirectory().getPath();
            String filePath = sdcardPath + "/"+pathName;
            File path = new File(filePath);
            File file = new File(filePath + fileName);
            if (!path.exists()) {
                UtilsLog.i("TestFile", "Create the path:" + filePath);
                path.mkdirs();
            }
            if (file != null && file.exists() && maxFileLength > 0) {
                if ( file.length() + data.length() > maxFileLength * 1024) {
                    file.delete();
                }
            }
            if (!file.exists()) {
                UtilsLog.i("TestFile", "Create the file:" + fileName);
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.seek(file.length());
            raf.write(data.getBytes());
            raf.close();
        } catch (Exception e) {
            UtilsLog.i("writeToSDCard", e.getMessage());
        }
    }

}
