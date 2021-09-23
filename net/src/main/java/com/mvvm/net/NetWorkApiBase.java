package com.mvvm.net;

import com.mvvm.net.base.BaseNetworkApi;
import com.mvvm.net.beans.TecentBaseResponse;
import com.mvvm.net.errorhandler.ExceptionHandle;
import com.mvvm.net.interceptor.TokenInterceptor;
import java.io.IOException;
import io.reactivex.functions.Function;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/**
* @author :WinterSweett
 * @description
 *
*/
public class NetWorkApiBase extends BaseNetworkApi {
    private static volatile NetWorkApiBase sInstance;
    private NetWorkApiBase(){
    }
    public static NetWorkApiBase getInstance() {
        if (sInstance == null) {
            synchronized (NetWorkApiBase.class) {
                if (sInstance == null) {
                    sInstance = new NetWorkApiBase();
                }
            }
        }
        return sInstance;
    }

    public static  <T> T getService(Class<T> service) {
        return getInstance().getRetrofit(service).create(service);
    }
    @Override
    protected Interceptor getTokenInterceptor() {
        return new TokenInterceptor();
    }
    @Override
    protected Interceptor getInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                builder.addHeader("Content-Type", "application/json;charset=UTF-8");
                builder.addHeader("X-Client-Type", "app");

                return chain.proceed(builder.build());
            }
        };
    }

    @Override
    protected <T> Function<T, T> getAppErrorHandler() {
        return new Function<T, T>() {
            @Override
            public T apply(T response) throws Exception {
                //response中code码不会0 出现错误
                if (response instanceof TecentBaseResponse && ((TecentBaseResponse) response).showapiResCode != 0) {
                    ExceptionHandle.ServerException exception = new ExceptionHandle.ServerException();
                    exception.code = ((TecentBaseResponse) response).showapiResCode;
                    exception.message = ((TecentBaseResponse) response).showapiResError != null ? ((TecentBaseResponse) response).showapiResError : "";
                    throw exception;
                }
                return response;
            }
        };
    }
}
