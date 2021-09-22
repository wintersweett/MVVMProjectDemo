package com.mvvm.net.commoninterceptor;


import com.mvvm.base.utils.UtilsLog;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/
public class CommonResponseInterceptor implements Interceptor {
    private static final String TAG = "ResponseInterceptor";
    @Override
    public Response intercept(Chain chain) throws IOException {
        long requestTime = System.currentTimeMillis();
        Response response = chain.proceed(chain.request());
        UtilsLog.d(TAG, "requestTime="+ (System.currentTimeMillis() - requestTime));
        return response;
    }
}
