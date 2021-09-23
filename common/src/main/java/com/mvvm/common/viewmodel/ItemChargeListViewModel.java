package com.mvvm.common.viewmodel;


import androidx.databinding.ObservableBoolean;

import com.mvvm.base.customview.BaseCustomViewModel;


/**
* @author :WinterSweett
 * @description
 *
*/
public class ItemChargeListViewModel extends BaseCustomViewModel {
    public String statusCode ;
    public String statusMsg ;
    public int id ;//chargeId
    //列表里的
    public String titel ; //全日出行包
    public String label ;//赠送一小时
    public double price ;//0.05
    public String descs ;//不计里程，超出出行包按每小时¥50/小时

    //出行保障
    public String titleInsurance ; //出行保障
    public String content ;//包含车损全陪以及三者100万
    public double priceInsurance ;//0.1
    public ObservableBoolean isSelected = new ObservableBoolean();

    public String priceDesc ;



}
