package com.mvvm.net.base;

import com.alibaba.android.arouter.BuildConfig;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mvvm.net.commoninterceptor.CommonRequestInterceptor;
import com.mvvm.net.commoninterceptor.CommonResponseInterceptor;
import com.mvvm.net.errorhandler.HttpErrorHandler;
import com.mvvm.net.interceptor.RetryInterceptor;
import com.mvvm.net.utils.Constant;

import java.net.Proxy;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/
public abstract class BaseNetworkApi  {
    private static INetworkRequiredInfo iNetworkRequiredInfo;
    private static HashMap<String, Retrofit> retrofitHashMap = new HashMap<>();
    public static String mBaseUrl ;
    private OkHttpClient mOkHttpClient;
    public static String mIsFormal = "";
    private static final int DEFAULT_CONNECT_TIMEOUT = 60;
    private static final int DEFAULT_WRITE_TIMEOUT = 40;
    private static final int DEFAULT_READ_TIMEOUT = 40;
    public BaseNetworkApi() {
    }

    public static void init(INetworkRequiredInfo networkRequiredInfo) {
        iNetworkRequiredInfo = networkRequiredInfo;
        mBaseUrl = Constant.BASE_URL_PERF ;
    }
    protected Retrofit getRetrofit(Class service) {
        if (retrofitHashMap.get(mBaseUrl + service.getName()) != null) {
            return retrofitHashMap.get(mBaseUrl + service.getName());
        }
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
        retrofitBuilder.baseUrl(mBaseUrl);
        retrofitBuilder.client(getOkHttpClient());
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create());
        retrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        Retrofit retrofit = retrofitBuilder.build();
        retrofitHashMap.put(mBaseUrl + service.getName(), retrofit);
        return retrofit;
    }

    private OkHttpClient getOkHttpClient() {
        if (mOkHttpClient == null) {
            OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
            if (getInterceptor() != null) {
                okHttpClientBuilder.addInterceptor(getInterceptor());
            }
//            if(getTokenInterceptor() != null){
//                okHttpClientBuilder.addInterceptor(getTokenInterceptor()) ;
//            }
            int cacheSize = 100 * 1024 * 1024; // 10MB
            okHttpClientBuilder.cache(new Cache(iNetworkRequiredInfo.getApplicationContext().getCacheDir(), cacheSize));
            okHttpClientBuilder.addInterceptor(new CommonRequestInterceptor(iNetworkRequiredInfo));
            okHttpClientBuilder.addInterceptor(new CommonResponseInterceptor());
            okHttpClientBuilder.connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS);
            okHttpClientBuilder.readTimeout(DEFAULT_WRITE_TIMEOUT,TimeUnit.SECONDS);
            okHttpClientBuilder.writeTimeout(DEFAULT_WRITE_TIMEOUT,TimeUnit.SECONDS);
            okHttpClientBuilder.addInterceptor(new RetryInterceptor(3));
            //okHttpClientBuilder.sslSocketFactory(getOkHttpClient().sslSocketFactory(),)

            if(!BuildConfig.DEBUG){
                okHttpClientBuilder.proxy(Proxy.NO_PROXY);
            }
            if (iNetworkRequiredInfo != null &&(iNetworkRequiredInfo.isDebug())) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLogger());
                httpLoggingInterceptor.setLevel(Level.BODY);
                okHttpClientBuilder.addNetworkInterceptor(httpLoggingInterceptor);
            }
            mOkHttpClient = okHttpClientBuilder.build();
        }
        return mOkHttpClient;
    }

    public  <T> ObservableTransformer<T, T> applySchedulers(final Observer<T> observer) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                Observable<T> observable = (Observable<T>)upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(getAppErrorHandler())
                        .onErrorResumeNext(new HttpErrorHandler<T>());
                observable.subscribe(observer);
                return observable;
            }
        };
    }

    protected abstract Interceptor getTokenInterceptor();
    protected abstract Interceptor getInterceptor();

    protected abstract <T> Function<T, T> getAppErrorHandler();
}