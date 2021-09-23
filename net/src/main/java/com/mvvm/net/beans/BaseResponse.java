package com.mvvm.net.beans;

import androidx.annotation.Keep;

import java.io.Serializable;

/**
* @author :WinterSweett
 * @description
 *
*/
@Keep
public class BaseResponse implements Serializable {

    private int errorCode;

    private String errorMsg;

    public void setErrorCode(int errorCode){
        this.errorCode = errorCode;
    }
    public int getErrorCode(){
        return this.errorCode;
    }
    public void setErrorMsg(String errorMsg){
        this.errorMsg = errorMsg;
    }
    public String getErrorMsg(){
        return this.errorMsg;
    }
}
