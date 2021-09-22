package com.mvvm.net.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/
public class ResponseInterceptor implements Interceptor {
    public ResponseInterceptor(){}
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long startRequestTime = System.currentTimeMillis();
        String url = request.url().toString();
        Response response = null;
        response = chain.proceed(request);
        String rawJson = response.body() == null ? "": response.body().string();
        return response.newBuilder().body(ResponseBody.create(response.body().contentType(),rawJson)).build();
    }
}
