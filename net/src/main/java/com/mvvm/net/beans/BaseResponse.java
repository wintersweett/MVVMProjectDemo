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
    /**
     * statusCode : 0
     * statusMessage : 处理成功
     * total : 1
     */

    private String statusCode;
    private String statusMessage;
    private int total;


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
