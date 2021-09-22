package com.mvvm.net.interceptor;

import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.mvvm.base.model.BaseModel;
import com.mvvm.base.model.IBaseModelListener;
import com.mvvm.base.model.PagingResult;
import com.mvvm.base.preference.BasicDataPreferenceUtil;
import com.mvvm.base.utils.Constance;
import com.mvvm.base.utils.ConstantFinal;
import com.mvvm.base.utils.StringUtils;
import com.mvvm.base.utils.ToastUtil;
import com.mvvm.base.utils.UtilsLog;
import com.mvvm.net.model.RefreshTokenModel;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class TokenInterceptor implements Interceptor {
    String tokenPreference = "" ;
    String token ="";
    Charset UTF8 = Charset.forName("UTF-8");
    /**
     * @param:
    *
    */
    @Override
    public Response intercept(Chain chain) throws IOException {
        tokenPreference = BasicDataPreferenceUtil.getInstance().getString(ConstantFinal.TOKEN) ;
        UtilsLog.d("zhm","TokenInterceptor中从PreferenceUtil中取："+tokenPreference);
        if (StringUtils.isNullOrEmpty(tokenPreference)) {
            token = "Bearer ehptlkssssss";
        } else {
            token = "Bearer "+tokenPreference ;
        }
        //拿到请求实体 并添加header
        Request request = chain.request().newBuilder()
                .addHeader("Authorization",token)
                .build() ;
        //拿到响应实体
        Response response = chain.proceed(request) ;
        int code = response.code() ;
         ResponseBody responseBody = response.body();
        //得到缓冲源
        BufferedSource source = responseBody.source();
        //请求全部
        source.request(Long.MAX_VALUE);
        Buffer buffer = source.buffer();
        Charset charset = UTF8;
        MediaType contentType = responseBody.contentType();
        if (contentType != null) {
            charset = contentType.charset(UTF8);
        }
        //读取返回数据
        String bodyString = buffer.clone().readString(charset);
        String statusCode = "";
        if (bodyString != null) {
            //处理返回的数据
            ExceptionStatusCode exceptionStatusCode;
            exceptionStatusCode = new Gson().fromJson(bodyString, ExceptionStatusCode.class);
            statusCode= exceptionStatusCode.getStatusCode();
            //BaseEntity baseEntity = JSON.parseObject(bodyString,BaseEntity.class);
            UtilsLog.i("zhm", "intercept中statuscode：" + statusCode);
            String exceptionmsg = exceptionStatusCode.getStatusMessage();
            if("201".equals(statusCode) && !BasicDataPreferenceUtil.getInstance().getBoolean(ConstantFinal.IS_LOGINED,false)){
                ARouter.getInstance().build(Constance.LOGIN_ACTIVITY).navigation();
            }
        }
        UtilsLog.d("zhm","token : "+token) ;
        UtilsLog.d("zhm","token : statuscode："+statusCode) ;
        UtilsLog.d("zhm","token TokenInterceptor code : "+code);
        if(401 == code && !BasicDataPreferenceUtil.getInstance().getBoolean(ConstantFinal.IS_LOGINED,false)){
            ARouter.getInstance().build(Constance.LOGIN_ACTIVITY).navigation();
           // AppManager.getInstance().finishAllViewModels();
        }
        if((401 == code || "201".equals(statusCode) ) && BasicDataPreferenceUtil.getInstance().getBoolean(ConstantFinal.IS_LOGINED,false) ){
            //TODO 重新获取token
            RefreshTokenModel refreshTokenModel = new RefreshTokenModel();
            refreshTokenModel.register(iBaseModelListener);
            refreshTokenModel.getCachedDataAndLoad();
            //替换掉之前的token重新请求接口
            Request mRequest = request.newBuilder()
                    .header("Authorization", "Bearer "+BasicDataPreferenceUtil.getInstance().getString(ConstantFinal.TOKEN))
                    .build();
            return chain.proceed(mRequest) ;
        }

        return response;
    }
    IBaseModelListener iBaseModelListener = new IBaseModelListener() {
        @Override
        public void onLoadFinish(BaseModel model, Object data, PagingResult... pageResult) {
            if(model instanceof RefreshTokenModel){
                RefreshTokenModel.Token token = (RefreshTokenModel.Token) data;
                if("0".equals(token.statusCode)) {
                    UtilsLog.d("zhm", "刷新token后 token：" + token.token);
                    BasicDataPreferenceUtil.getInstance().setString(ConstantFinal.TOKEN, token.token);
                }else {
                   // ToastUtil.show(token.statusMsg);
                    ARouter.getInstance().build(Constance.LOGIN_ACTIVITY).navigation();
                    UtilsLog.d("zhm","token code "+token.statusCode);
                }
            }

        }

        @Override
        public void onLoadFail(BaseModel model, String prompt, PagingResult... pageResult) {
            ToastUtil.show(prompt);
            UtilsLog.d("zhm","prompt "+prompt);


        }
    };
}
