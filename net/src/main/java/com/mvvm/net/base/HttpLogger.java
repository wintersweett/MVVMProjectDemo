package com.mvvm.net.base;


import com.mvvm.base.utils.GsonUtils;
import com.mvvm.base.utils.LogUtils;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class HttpLogger implements HttpLoggingInterceptor.Logger {
    private StringBuilder mMessage = new StringBuilder();
    @Override
    public void log(String message) {
// 请求或者响应开始
        if (message.startsWith("--> POST")) {
            mMessage.setLength(0);
        }
        // 以{}或者[]形式的说明是响应结果的json数据，需要进行格式化
        if ((message.startsWith("{") && message.endsWith("}"))
                || (message.startsWith("[") && message.endsWith("]"))) {
            message = GsonUtils.formatJson(GsonUtils.decodeUnicode(message));
        }
        mMessage.append(message.concat("\n"));
        // 响应结束，打印整条日志
        if (message.startsWith("<-- END HTTP")) {
            LogUtils.d(mMessage.toString());
        }

    }
}
