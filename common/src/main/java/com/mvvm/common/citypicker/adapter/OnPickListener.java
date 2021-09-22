package com.mvvm.common.citypicker.adapter;


import com.mvvm.common.citypicker.model.City;

public interface OnPickListener {
    void onPick(int position, City data);
    void onLocate();
    void onCancel();
}
