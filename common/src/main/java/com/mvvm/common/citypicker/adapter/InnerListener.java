package com.mvvm.common.citypicker.adapter;


import com.mvvm.common.citypicker.model.City;

public interface InnerListener {
    void dismiss(int position, City data);
    void locate();
}
