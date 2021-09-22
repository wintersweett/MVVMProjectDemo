package com.mvvm.base.utils;

import static com.mvvm.base.utils.DateUtils.WeekShort;
import static com.mvvm.base.utils.DateUtils.toDate;

import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class TimeUtils {
    /**
     * @param:将今天或者明天 --》10月22日 周四
    *
     * @return
     */
    public static int[] getCurTime(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR) ;
        int month = calendar.get(Calendar.MONTH) ;
        int day = calendar.get(Calendar.DAY_OF_MONTH) ;
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE) ;
        int[] time = new int[5];
        time[0]=year;
        time[1]=month;
        time[2]=day;
        time[3]=hour;
        time[4]=minute;
        return time;

    }
    /**
     * @param:
    * 明天的年月日
    */
    public static int[] getTomTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,1);
        int year = calendar.get(Calendar.YEAR) ;
        int month = calendar.get(Calendar.MONTH) ;
        int day = calendar.get(Calendar.DAY_OF_MONTH) ;
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE) ;
        int[] time = new int[5];
        time[0]=year;
        time[1]=month;
        time[2]=day;
        time[3]=hour;
        time[4]=minute;
        return time;
    }
    /**
     * @param:比今天晚 delay天
     * @return  年月日时分的数组
     *
    */
    public static int[] getDelayTime(int delay){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,delay);
        int year = calendar.get(Calendar.YEAR) ;
        int month = calendar.get(Calendar.MONTH) ;
        int day = calendar.get(Calendar.DAY_OF_MONTH) ;
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE) ;
        int[] time = new int[5];
        time[0]=year;
        time[1]=month;
        time[2]=day;
        time[3]=hour;
        time[4]=minute;
        return time;
    }

    //3月13日 周五 18：00  有现车-->xxxx-x-xx xx:xx:xx
    public static String transfromToFormal(String day){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar c = Calendar.getInstance();
        if("今天".equals(day)){
            return simpleDateFormat.format(c.getTime()) ;
        }else if("明天".equals(day)){
            c.add(Calendar.DAY_OF_MONTH,1);
            return simpleDateFormat.format(c.getTime());
        }
        return "" ;


    }
    /**
     * @param:
    *
    */
    public static int addDaysDelay(int day , int durTimeDelay){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        c.set(Calendar.DAY_OF_MONTH,day+durTimeDelay);
            return c.get(Calendar.DAY_OF_MONTH);
    }
    

    public static String transform(String day){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar c = Calendar.getInstance();
        if("今天".equals(day)){
            return sf.format(c.getTime()) ;
        }else if("明天".equals(day)){
            c.add(Calendar.DAY_OF_MONTH,1);
            return sf.format(c.getTime());
        }
        return "" ;
    }
    public static String getDefaultCurrentTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       return format.format(new Date());

    }
/**
 * @param: 今天 或 明天
 *
*
*/
    public static String transformWithChinese(String day){
        SimpleDateFormat sf = new SimpleDateFormat("MM月dd日");
        Calendar c = Calendar.getInstance();
        if("今天".equals(day)){
            return sf.format(c.getTime()) ;
        }else if("明天".equals(day)){
            c.add(Calendar.DAY_OF_MONTH,1);
            return sf.format(c.getTime());
        }
        return "" ;
    }

    public static String getWeek(String pTime) {
        String Week = "";
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            Week += "周天";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 2) {
            Week += "周一";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 3) {
            Week += "周二";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 4) {
            Week += "周三";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 5) {
            Week += "周四";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 6) {
            Week += "周五";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 7) {
            Week += "周六";
        }
        return Week;
    }
    /**
     * @param:
    *取车时间 和还车时间，传入不同的dur 。
     * return : 2月23日
    */
    public static String  getCarTime(Context context , int dur){
        SimpleDateFormat sf = new SimpleDateFormat("MM月dd日");
        Calendar c = Calendar.getInstance();
        String month_day = "";
        c.add(Calendar.DAY_OF_MONTH,dur);
        month_day = sf.format(c.getTime());
        return month_day ;
    }

    /**
     * @param:
     * 。
     * return : 02月23日
     */
    public static String  getCarTime(String str){
        SimpleDateFormat sf = new SimpleDateFormat("MM月dd日");
        Calendar c = Calendar.getInstance();
        c.setTime(toDate(str));
      String  month_day = sf.format(c.getTime());
        return month_day ;
    }


    public static String getHourMinute(String str){
        String  hour_minute = str.substring(11,16);
        return hour_minute ;
    }
    /**
     * @param: dur :间隔时间
    *return : 2-23
    */
    public static String  getCarTimeHeng(Context context , int dur){
        SimpleDateFormat sf = new SimpleDateFormat("MM-dd");
        Calendar c = Calendar.getInstance();
        String month_day = "";
        c.add(Calendar.DAY_OF_MONTH,dur);
        month_day = sf.format(c.getTime());
        return month_day ;
    }




    /**
     * @param:
    *比较日期大小
    */
    public static boolean compareTime(String beiginTime ,String endTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date bt = sdf.parse(beiginTime) ;
            Date et = sdf.parse(endTime) ;
            return bt.before(et) ;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * @param:
     *比较日期大小
     */
    public static boolean compareFormalTime(String beiginTime ,String endTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date bt = sdf.parse(beiginTime) ;
            Date et = sdf.parse(endTime) ;
            return bt.before(et) ;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
    // 计算两个日期间的间隔天数
    public static long getDaysFromTwoDate(String txtDate1, String txtDate2) {
        if(txtDate1 == null || txtDate1.equals("")) {
            return 0;
        }
        if(txtDate2 == null || txtDate2.equals("")) {
            return 0;
        }

        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long days = 0;
        try {
            Date date1 = sDateFormat.parse(txtDate1);
            Date date2 = sDateFormat.parse(txtDate2);
            days = (date2.getTime() - date1.getTime())/(24*60*60*1000);		// 通过getTime()方法，把时间Date转换成毫秒格式Long类型，进行计算
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return days;
    }

    /**
     * @param: 标准的时间2021-04-05 10:20:00
    * @return  2月4日
    */
    public static String  getMonthDay(String formalDate){
        SimpleDateFormat sf = new SimpleDateFormat("MM月dd日");
        String  month_day = sf.format(toDate(formalDate));
        return month_day ;
    }
/**
 * @param:2021-04-05 10:20:00
*  @return  转用于长短租首页改变时间：周六 10:00
*/
    public static String  getWeekHourMinute(String str){
        String weekShort =  WeekShort(str);
        System.out.println(weekShort);
        String hm = str.substring(11,16);
      return hm;

    }
    /**
     * @param: 12:24
     *   将week后面的时间 返回  整点 或者半点
     *   2021-12-23 03:30:00
     */
    public static String[] getArrHourMinute(String str){
        String hour = str.substring(11,13);
        String minut = str.substring(14,16);
        int minuteInt = Integer.parseInt(minut);
        String[] resHourMinute = new String[2];
        if(minuteInt == 0){
            resHourMinute[0] = hour;
            resHourMinute[1] = minut;
        }else if(minuteInt <=30){
            resHourMinute[0] = hour ;
            resHourMinute[1] = "30";
        }else if(minuteInt >30){
            String addedTime = DateUtils.addDate( str,1);  //2021-02-23 02:20:00
            String  addedHour = addedTime.substring(11,13);
            resHourMinute[0] = addedHour ;
            resHourMinute[1] = "00";
        }
        return resHourMinute;
    }

    public static int durHour(int startHour,int defaultHour){
        return defaultHour-startHour ;
    }
    /**
     * @param:
    *计算默认的minute是在时间控件的第几个
    */
    public static int durMinute(String defaultMinute){
        if("00".equals(defaultMinute)){
            return 0;
        }else if("30".equals(defaultMinute)){
            return 1;
        }
     return -1;
    }


}
