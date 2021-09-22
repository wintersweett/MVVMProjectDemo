package com.mvvm.common.views;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.annotation.DrawableRes;
import androidx.annotation.Keep;
import androidx.appcompat.app.AlertDialog;

import com.mvvm.base.utils.StringUtils;
import com.mvvm.common.R;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class DialogLongShort extends Dialog{
    private static WebView webView;
        public DialogLongShort(Context context, int theme) {
            super(context, theme);
        }
        @Keep
        public static class Builder {
            private Context context;
            private String title;
            private String message;
            private String positiveButtonText;
            private String negativeButtonText;
            private View contentView;
            private String url ;
            @DrawableRes
            private int drawable ;
            private DialogInterface.OnClickListener positiveButtonClickListener;
            private DialogInterface.OnClickListener negativeButtonClickListener;

            public Builder(Context context) {
                this.context = context;
            }
            public DialogLongShort.Builder setUrl(String mUrl){
                this.url = mUrl;
                return this;
            }

            public DialogLongShort.Builder setDrawable(@DrawableRes int resid){
                this.drawable = resid;
                return this;
            }
            public DialogLongShort.Builder setMessage(String message) {
                this.message = message;
                return this;
            }

            /**
             * Set the Dialog message from resource
             *
             * @param
             * @return
             */
            public DialogLongShort.Builder setMessage(int message) {
                this.message = (String) context.getText(message);
                return this;
            }

            /**
             * Set the Dialog title from resource
             *
             * @param title
             * @return
             */
            public DialogLongShort.Builder setTitle(int title) {
                this.title = (String) context.getText(title);
                return this;
            }

            /**
             * Set the Dialog title from String
             *
             * @param title
             * @return
             */

            public DialogLongShort.Builder setTitle(String title) {
                this.title = title;
                return this;
            }

            public DialogLongShort.Builder setContentView(View v) {
                this.contentView = v;
                return this;
            }

            /**
             * Set the positive button resource and it's listener
             *
             * @param positiveButtonText
             * @return
             */
            public DialogLongShort.Builder setPositiveButton(int positiveButtonText,
                                                                                DialogInterface.OnClickListener listener) {
                this.positiveButtonText = (String) context
                        .getText(positiveButtonText);
                this.positiveButtonClickListener = listener;
                return this;
            }

            public DialogLongShort.Builder setPositiveButton(String positiveButtonText,
                                                                                DialogInterface.OnClickListener listener) {
                this.positiveButtonText = positiveButtonText;
                this.positiveButtonClickListener = listener;
                return this;
            }

            public DialogLongShort.Builder setNegativeButton(int negativeButtonText,
                                                                                DialogInterface.OnClickListener listener) {
                this.negativeButtonText = (String) context
                        .getText(negativeButtonText);
                this.negativeButtonClickListener = listener;
                return this;
            }

            public DialogLongShort.Builder setNegativeButton(String negativeButtonText,
                                                                                DialogInterface.OnClickListener listener) {
                this.negativeButtonText = negativeButtonText;
                this.negativeButtonClickListener = listener;
                return this;
            }
            ImageView imageView ;



            public DialogLongShort create() {
                LayoutInflater inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                // instantiate the dialog with the custom Theme
                final DialogLongShort dialog = new DialogLongShort(context, R.style.Dialog);
                View layout = inflater.inflate(R.layout.dialog_longshort, null);
                dialog.addContentView(layout, new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                webView = (WebView)layout.findViewById(R.id.wv) ;
                WebSettings webSettings = webView.getSettings() ;
                //允许webview对文件的操作
                webSettings.setAllowUniversalAccessFromFileURLs(true);
                webSettings.setAllowFileAccess(true);
                webSettings.setAllowFileAccessFromFileURLs(true);
                //用于js调用Android
                webSettings.setJavaScriptEnabled(true);
                //设置编码方式
                webSettings.setDefaultTextEncodingName("utf-8");
                //访问网页Html
                if(!StringUtils.isNullOrEmpty(url)){
                    webView.loadUrl(url);
                }
                // set the dialog title
                ((TextView) layout.findViewById(R.id.tv_dialog_title)).setText(title);
                imageView = (ImageView)layout.findViewById(R.id.iv);
                if(drawable != 0){
                    imageView.setImageResource(drawable);
                }
                imageView.setBackgroundResource(R.drawable.apppay);
                // set the confirm button
                if (positiveButtonText != null) {
                    ((TextView) layout.findViewById(R.id.tv_left))
                            .setText(positiveButtonText);
                    if (positiveButtonClickListener != null) {
                        ((RelativeLayout) layout.findViewById(R.id.rl_left))
                                .setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        positiveButtonClickListener.onClick(dialog,
                                                DialogInterface.BUTTON_POSITIVE);
                                    }
                                });
                    }
                } else {
                    // if no confirm button just set the visibility to GONE
                    layout.findViewById(R.id.tv_left).setVisibility(
                            View.GONE);
                }
                // set the cancel button
                if (negativeButtonText != null) {
                    ((TextView) layout.findViewById(R.id.tv_right))
                            .setText(negativeButtonText);
                    if (negativeButtonClickListener != null) {
                        ((RelativeLayout) layout.findViewById(R.id.rl_right))
                                .setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        negativeButtonClickListener.onClick(dialog,
                                                DialogInterface.BUTTON_NEGATIVE);
                                    }
                                });
                    }
                } else {
                    // if no confirm button just set the visibility to GONE
                    layout.findViewById(R.id.tv_right).setVisibility(
                            View.GONE);
                }
                // set the content message
                if (message != null) {
                    ((TextView) layout.findViewById(R.id.tv_dialog_content)).setText(message);
                } else if (contentView != null) {
                    // if no message set
                    // add the contentView to the dialog body
//                    ((TextView) layout.findViewById(R.id.tv_dialog_content))
//                            .removeAllViews();
//                    ((LinearLayout) layout.findViewById(R.id.content))
//                            .addView(contentView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
                }
                dialog.setContentView(layout);
                return dialog;
            }
        }

}
