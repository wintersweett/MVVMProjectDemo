package com.mvvm.net.interceptor;

import android.text.TextUtils;


import com.mvvm.net.INetWorkRequestInfo;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/
public class RequestInterceptor implements Interceptor {
    private INetWorkRequestInfo mNetworkRequestInfo ;
    public RequestInterceptor(INetWorkRequestInfo netWorkRequestInfo){
        this.mNetworkRequestInfo = netWorkRequestInfo;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request()
                .newBuilder();
        if(mNetworkRequestInfo != null){
            for(String key : mNetworkRequestInfo.getRequestHeaderMap().keySet()){
                if(!TextUtils.isEmpty(mNetworkRequestInfo.getRequestHeaderMap().get(key))){
                    builder.addHeader(key,mNetworkRequestInfo.getRequestHeaderMap().get(key));
                }
            }
        }
        return chain.proceed(builder.build());
    }
}
