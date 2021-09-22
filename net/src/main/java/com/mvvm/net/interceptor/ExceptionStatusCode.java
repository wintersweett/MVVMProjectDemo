package com.mvvm.net.interceptor;

import java.io.Serializable;

public class ExceptionStatusCode implements Serializable {


    /**
     * statusCode : 11005311
     * statusMessage : accessToken凭据无效
     */

    private String statusCode;
    private String statusMessage;

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
}
