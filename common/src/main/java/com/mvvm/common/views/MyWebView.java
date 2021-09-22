package com.mvvm.common.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.mvvm.base.utils.StringUtils;


public class MyWebView extends WebView {
	Context mContext;

	public MyWebView(Context context) {
		super(context);
		this.mContext = context;
		init();
	}

	public MyWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
		init();
	}

	public MyWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.mContext = context;
		init();
	}

	@SuppressLint("NewApi")
	private void init() {
		setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);// 设置滚动条的宽度
		setDrawingCacheEnabled(true);
		WebSettings webSettings = getSettings();
		webSettings.setJavaScriptEnabled(true);// 支持js脚本
		webSettings.setSaveFormData(false);// 是否保存表单数据
		webSettings.setSavePassword(false);// 是否保存密码
		webSettings.setSupportZoom(false);// 是否支持缩放
		webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);// 提高渲染的优先级
		webSettings.setBlockNetworkImage(false);// 把图片加载放在最后来加载渲染
		webSettings.setUseWideViewPort(true);
		/***打开本地缓存提供JS调用**/ 
		webSettings.setDomStorageEnabled(true);  
		webSettings.setAppCacheMaxSize(1024*1024*8);  
		try{
			String appCachePath = mContext.getCacheDir().getAbsolutePath();  
	    	webSettings.setAppCachePath(appCachePath);  
	 	    webSettings.setAllowFileAccess(true);  
	 	    webSettings.setAppCacheEnabled(true);
		} catch(Exception e){
			
		}
		   

	   
	}
	@Override
	public void loadUrl(String url) {

		if (StringUtils.isNullOrEmpty(url)) {
			return;
		}
		super.loadUrl(url);
	}

}
