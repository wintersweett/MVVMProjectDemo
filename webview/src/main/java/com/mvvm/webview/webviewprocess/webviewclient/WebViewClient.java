package com.mvvm.webview.webviewprocess.webviewclient;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;

import com.mvvm.webview.WebViewCallBack;

public class WebViewClient extends android.webkit.WebViewClient {
    private WebViewCallBack mWebViewCallBack;
    private static final String TAG = "XiangxueWebViewClient";

    public WebViewClient(WebViewCallBack callBack){
        this.mWebViewCallBack = callBack;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        if(mWebViewCallBack != null) {
            mWebViewCallBack.pageStarted(url);
        } else {
            Log.e(TAG, "WebViewCallBack is null.");
        }
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        if(mWebViewCallBack != null) {
            mWebViewCallBack.pageFinished(url);
        } else {
            Log.e(TAG, "WebViewCallBack is null.");
        }
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
        if(mWebViewCallBack != null) {
            mWebViewCallBack.onError();
        } else {
            Log.e(TAG, "WebViewCallBack is null.");
        }
    }
}
