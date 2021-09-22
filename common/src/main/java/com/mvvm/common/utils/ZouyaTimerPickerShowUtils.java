package com.mvvm.common.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.mvvm.base.utils.DateUtils;
import com.mvvm.base.utils.TimeUtils;
import com.mvvm.common.R;
import com.mvvm.common.beans.TimersBean;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : WinterSweett
 * @time : {DATE}
 * 长短租 首页时间选择器逻辑
 */
public class ZouyaTimerPickerShowUtils {
   static OptionsPickerView pvOptions;
    private static List<TimersBean> longItems1 = new ArrayList<>();
    private static List<List<String>> longItems2 = new ArrayList<>();
    private static List<List<List<String>>> longItems3 = new ArrayList<>();
    static int durday ;
    static String defaultTime ;
    static String mStartTime ;

    //计算默认时间月日   点  分 分别在第几的位置
    //月日
   static   long lastTime;
    //hour 算当前hour 与8：00间隔多少个hour
   static String hour ;
  static    int durHour ;
    //minute
  static   String minute ;
  static   int durMinute ;
  static int startHour ;

    /**
     * @param: startTime 滚轴开始的时间
     * @param : 取车时间30天    还车时间15天
     * @param :mDefaultTime 调用页面传过来的默认时间
    *  startTime :标准的轮轴的开始时间
    */
    public static void  initLongShortRentJsonData(Context context,String startTime , int lastday,String mDefaultTime){
        lastTime = TimeUtils.getDaysFromTwoDate(startTime,mDefaultTime);
//        hour = TimeUtils.getArrHourMinute(mDefaultTime)[0];
//        minute = TimeUtils.getArrHourMinute(mDefaultTime)[1];
//        mStartTime = startTime ;
//        defaultTime = mDefaultTime;


        durday = lastday;
        LinkedList<TimersBean> linkedList = new LinkedList<>();
        String year = DateUtils.getYearFromString(startTime);
        String  month = DateUtils.getMonthFromString(startTime);
        String day = DateUtils.getDayFromString(startTime);
        int curHour = Integer.parseInt(DateUtils.getHourFromString(startTime));
        Calendar c = Calendar.getInstance();
        String month_day = "";
        L:
        for(int i =0 ;i<lastday ;i++){
            TimersBean timersBean = new TimersBean();
            Date date = DateUtils.toDate(startTime);
            String time = DateUtils.getDaysDelay(date,i);
            month_day = TimeUtils.getMonthDay(time);
            timersBean.setDayName(month_day);
            linkedList.add(timersBean);
            List<String> hourList = new ArrayList<>();
            List<List<String>> day_minuteList = new ArrayList<>();
            if(i !=0){
               // startHour = 8 ;
                for(int j =8 ;j<23 ;j++){
                    TimersBean.HoursBean hoursBean = new TimersBean.HoursBean();
                    hoursBean.setHourName(j+"点");
                    hourList.add(j+"点");
                    List<String> minuteList = new ArrayList<>();
                    if(j!= 22){
                        minuteList.add("00分");
                        minuteList.add("30分");
                    }else{
                        minuteList.add("00分");
                    }
                    day_minuteList.addAll(Collections.singleton(minuteList));
                }
            }else { //时间控件进来的第一天
               // startHour = curHour+1;
                for(int j = curHour +1 ;j<23 ;j++){
                    TimersBean.HoursBean hoursBean = new TimersBean.HoursBean();
                    hoursBean.setHourName(j+"点");
                    hourList.add(j+"点");;
                    List<String> minuteList = new ArrayList<>();
                    if(j!= 22){
                        minuteList.add("00分");
                        minuteList.add("30分");
                    }else{
                        minuteList.add("00分");
                    }
                    day_minuteList.addAll(Collections.singleton(minuteList));
                }
                //continue L;

            }
            longItems2.addAll(Collections.singleton(hourList)); //hours
            longItems3.addAll(Collections.singleton(day_minuteList)); //minutes
        }
//        durMinute =  TimeUtils.durMinute(minute);
//        durHour = TimeUtils.durHour(8, Integer.parseInt(hour)) ;
        longItems1 = linkedList; //days
        initLongTimerShow(context);
    }
    public static void   initLongTimerShow(Context context){

        pvOptions = new OptionsPickerBuilder(context, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String opt1tx = longItems1.size() > 0 ?
                        longItems1.get(options1).getPickerViewText() : ""; //03月04日

                String opt2tx = longItems2.size() > 0
                        && longItems2.get(options1).size() > 0 ?
                        longItems2.get(options1).get(options2) : ""; //8点

                String opt3tx = longItems2.size() > 0
                        && longItems3.get(options1).size() > 0
                        && longItems3.get(options1).get(options2).size() > 0 ?
                        longItems3.get(options1).get(options2).get(options3) : "";//00分
                String[] strings = new String[5];
                strings[0] = opt1tx ; //月日
                strings[1] = opt2tx; // hour
                strings[2] = opt3tx ; //minute
                strings[3] =durday+""; //30 还是15
                strings[4] = TimeUtils.getCurTime()[0]+""; //年
                EventBus.getDefault().post(strings);
                String tx = opt1tx + opt2tx + opt3tx;
                Log.d("zhm", "onOptionsSelect: "+tx);
            }
        })
                .setLayoutRes(R.layout.pickerview_custom_options, new CustomListener() {
                    @Override
                    public void customLayout(View v) {
                        final TextView tv_cancel = (TextView) v.findViewById(R.id.tv_finish);
                        final TextView tv_submit = (TextView)v.findViewById(R.id.tv_submit);
                        final TextView tv_title_title = (TextView)v.findViewById(R.id.tv_picker_options_title);
                        if(30 == durday){
                            tv_title_title.setText("选择取车时间");
                        }else if(15 == durday){
                            tv_title_title.setText("选择还车时间");
                        }
                        tv_cancel.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(pvOptions != null){
                                    pvOptions.dismiss();
                                }
                            }
                        });
                        tv_submit.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(pvOptions != null){
                                    pvOptions.returnData();
                                    pvOptions.dismiss();
                                }
                            }
                        });
                    }
                })
                .setSelectOptions((int) lastTime,0,0)
                .isDialog(false)
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();

        pvOptions.setPicker(longItems1, longItems2, longItems3);//三级选择器
        pvOptions.show();
    }
}
