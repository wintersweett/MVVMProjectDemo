package com.mvvm.common.utils;

import com.google.gson.Gson;
import com.mvvm.base.utils.GsonUtils;
import com.mvvm.common.beans.TimersBean;

import org.json.JSONArray;

import java.util.LinkedList;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class TimeZouyaUtils {
    public static LinkedList<TimersBean> parseTimerBean(String result) {//Gson 解析
        LinkedList<TimersBean> detail = new LinkedList<>();
        try {
            JSONArray data = new JSONArray(result);
           // Gson gson = new Gson();
            Gson gson = GsonUtils.getLocalGson();
            for (int i = 0; i < data.length(); i++) {
                TimersBean entity = gson.fromJson(data.optJSONObject(i).toString(), TimersBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }


}
