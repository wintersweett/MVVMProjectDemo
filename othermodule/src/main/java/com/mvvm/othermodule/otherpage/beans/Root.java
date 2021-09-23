package com.mvvm.othermodule.otherpage.beans;

import com.mvvm.net.beans.BaseResponse;

public class Root extends BaseResponse {
    private Data data;

    public void setData(Data data){
        this.data = data;
    }
    public Data getData(){
        return this.data;
    }
}
