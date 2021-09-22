package com.mvvm.base.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class DateUtils {
    //获取当前完整的日期和时间
    public static String getNowDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    //获取当前日期
    public static String getNowDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }
    /**
     * @param:2021-02-23
    * @return 02-23
    */
    public static String cutToShortDate(String str){
        if(!StringUtils.isNullOrEmpty(str)){
           return str.substring(5);
        }
        return null;
    }
    /**
     * @param: 2021-03-23 12:23:00
    *   03-23
    */

    public static String cutToMonthDayFromFormal(String str){
        String monthDay = str.substring(5,10);
        return monthDay;
    }

    //前一天
    public static String getYesterday(Date date) {
        String tomorrow = "";
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        tomorrow = formatter.format(date);
        return tomorrow;
    }
    /**
     * @param:
    *
    */
    //前一天
    public static String getYesterdayShort(Date date) {
        String tomorrow = "";
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
        tomorrow = formatter.format(date);
        return tomorrow;
    }

    //后一天
    public static String getTomorrow(Date date) {
        String tomorrow = "";
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, +1);
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        tomorrow = formatter.format(date);
        return tomorrow;
    }
    /**
     * @param:2 延后几天
     *
    *    //后几天
    */
    public static String getDaysDelay(Date date,int dur) {
        String tomorrow = "";
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, +dur);
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tomorrow = formatter.format(date);
        return tomorrow;
    }

    //获取当前时间
    public static String getNowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }

    //获取当前日期(精确到毫秒)
    public static String getNowTimeDetail() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        return sdf.format(new Date());
    }

    //获取今天是星期几
    public static String getWeekOfDate(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    //计算星期几
    public static int getDayOfWeek(String dateTime) {

        Calendar cal = Calendar.getInstance();
        if (dateTime.equals("")) {
            cal.setTime(new Date(System.currentTimeMillis()));
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Date date;
            try {
                date = sdf.parse(dateTime);
            } catch (ParseException e) {
                date = null;
                e.printStackTrace();
            }
            if (date != null) {
                cal.setTime(new Date(date.getTime()));
            }
        }
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    //根据年月日计算是星期几并与当前日期判断  非昨天、今天、明天 则以星期显示
    public static String Week(String dateTime) {
        String week = "";
        String yesterday = "";
        String today = "";
        String tomorrow = "";
        yesterday = getYesterday(new Date());
        today = getNowDate();
        tomorrow = getTomorrow(new Date());

//        if (dateTime.equals(yesterday)) {
//            week = "昨天";
//        } else if (dateTime.equals(today)) {
//            week = "今天";
//        } else if (dateTime.equals(tomorrow)) {
//            week = "明天";
//        } else {
            switch (getDayOfWeek(dateTime)) {
                case 1:
                    week = "星期日";
                    break;
                case 2:
                    week = "星期一";
                    break;
                case 3:
                    week = "星期二";
                    break;
                case 4:
                    week = "星期三";
                    break;
                case 5:
                    week = "星期四";
                    break;
                case 6:
                    week = "星期五";
                    break;
                case 7:
                    week = "星期六";
                    break;
            }

       // }


        return week;
    }
    //根据年月日计算是星期几并与当前日期判断  非昨天、今天、明天 则以星期显示
    public static String WeekShort(String dateTime) {
        String week = "";
        String yesterday = "";
        String today = "";
        String tomorrow = "";
        yesterday = getYesterday(new Date());
        today = getNowDate();
        tomorrow = getTomorrow(new Date());

//        if (dateTime.equals(yesterday)) {
//            week = "昨天";
//        } else if (dateTime.equals(today)) {
//            week = "今天";
//        } else if (dateTime.equals(tomorrow)) {
//            week = "明天";
//        } else {
        switch (getDayOfWeek(dateTime)) {
            case 1:
                week = "周日";
                break;
            case 2:
                week = "周一";
                break;
            case 3:
                week = "周二";
                break;
            case 4:
                week = "周三";
                break;
            case 5:
                week = "周四";
                break;
            case 6:
                week = "周五";
                break;
            case 7:
                week = "周六";
                break;
        }

        // }


        return week;
    }
    //将时间戳转化为对应的时间(10位或者13位都可以)
    public static String formatTime(long time) {
        String times = null;
        if (String.valueOf(time).length() > 10) {// 10位的秒级别的时间戳
            times = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time * 1000));
        } else {// 13位的秒级别的时间戳
            times = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
        }
        return times;
    }

    //将时间字符串转为时间戳字符串
    public static String getStringTimestamp(String time) {
        String timestamp = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long longTime = sdf.parse(time).getTime() / 1000;
            timestamp = Long.toString(longTime);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp;
    }
    /**
     * @param: 2021-03-04
    * @return  2021
    */
    public static String  getYearFromString(String time){
      Date date =  getDate(time) ;
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
      String year = dateFormat.format(date);
       return year ;
    }
    /**
     * @param: 2021-03-04
     * @return  03
     */
    public static String  getMonthFromString(String time){
        Date date =  getDate(time) ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
        String month = dateFormat.format(date);
        return month ;
    }
    /**
     * @param: 2021-03-04
     * @return  04
     */
    public static String  getDayFromString(String time){
        Date date =  getDate(time) ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        String day = dateFormat.format(date);
        return day ;
    }
    /**
     * @param: 2021-03-04 12:33:00
     * @return  12
     */
    public static String  getHourFromString(String time){

        String hour = time.substring(11,13);
        return hour ;
    }
    /**
     * @param: 2021-03-04 12:33:00
     * @return  00
     */
    public static String  getMinuteFromString(String time){

        String hour = time.substring(14,16);
        return hour ;
    }

    /**
     * @param: 2021-03-04 12:33:00
     * @return  12:33
     */
    public static String  getHourMinuteFromString(String time){
        Date date =  getDate(time) ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String hourMinute = dateFormat.format(date);
        return hourMinute ;
    }

    /**
     * @param: 2021-03-22
    * @return  Date
    */
    public static Date getDate(String time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(time) ;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
/**
 * @param:2021-04-06 11:00:00
*
*/
    public static Date toDate(String dateStr) {
        //格式化数据
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
/**
 * @param: x为hour增加的
*给某个标准时间增加x小时后取得的标准时间
 * 2009-03-23 08:00:00 --》x 为15 时候 得到2009-03-23 23:00:00
*/
    public static String addDate(String day, int x)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//12小时制
        Date date = null;
        try
        {
            date = format.parse(day);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        if (date == null) return "";
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, x);//24小时制
        //cal.add(Calendar.HOUR, x);12小时制
        date = cal.getTime();
        System.out.println("front:" + date);
        cal = null;
        return format.format(date);
    }
}
