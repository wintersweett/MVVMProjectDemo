package com.mvvm.net.commoninterceptor;


import com.mvvm.net.base.INetworkRequiredInfo;

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
public class CommonRequestInterceptor implements Interceptor {
    private INetworkRequiredInfo requiredInfo;
    public CommonRequestInterceptor(INetworkRequiredInfo requiredInfo){
        this.requiredInfo = requiredInfo;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        //builder.cacheControl(CacheControl.FORCE_CACHE);
        builder.addHeader("os", "android");
        builder.addHeader("appVersion",this.requiredInfo.getAppVersionCode());
        return chain.proceed(builder.build());
    }
}
