package com.mvvm.common.views;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Keep;

import com.mvvm.base.utils.StringUtils;
import com.mvvm.common.R;
import com.mvvm.common.utils.TypeFaceUtils;


/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class MsgDialog extends Dialog {

    public MsgDialog(Context context) {
        super(context);
    }

    public MsgDialog(Context context, int theme) {
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
        @DrawableRes
        private int drawable;
        private boolean rl_left_isVisible = true ;
        private String rightName ;
        private String leftName ;
        private boolean tv_subTitle_isVisible = true ;

        private DialogInterface.OnClickListener positiveButtonClickListener;
        private DialogInterface.OnClickListener negativeButtonClickListener;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setDrawable(@DrawableRes int resid) {
            this.drawable = resid;
            return this;
        }
        public Builder setSubTitleVisible(boolean isVisible){
            this.tv_subTitle_isVisible = isVisible ;
            return this;
        }
        public Builder setVisibility( boolean isVisible){
            this.rl_left_isVisible = isVisible ;
            return this;
        }
        public Builder setLeftName(String leftName){
            this.leftName = leftName ;
            return this;
        }

        public Builder setRightName(String rightName){
            this.rightName = rightName ;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setMessage(int message) {
            this.message = (String) context.getText(message);
            return this;
        }

        public Builder setTitle(int title) {
            this.title = (String) context.getText(title);
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setContentView(View v) {
            this.contentView = v;
            return this;
        }

        public Builder setPositiveButton(int positiveButtonText, DialogInterface.OnClickListener listener) {
            this.positiveButtonText = (String) context
                    .getText(positiveButtonText);
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setPositiveButton(String positiveButtonText, DialogInterface.OnClickListener listener) {
            this.positiveButtonText = positiveButtonText;
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(int negativeButtonText, DialogInterface.OnClickListener listener) {
            this.negativeButtonText = (String) context
                    .getText(negativeButtonText);
            this.negativeButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(String negativeButtonText, DialogInterface.OnClickListener listener) {
            this.negativeButtonText = negativeButtonText;
            this.negativeButtonClickListener = listener;
            return this;
        }

        ImageView imageView;
        RelativeLayout rl_left ;
        TextView tv_verify ;
        TextView tv_cancel ;
        TextView tv_msg ;

        public MsgDialog create() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final MsgDialog dialog = new MsgDialog(context, R.style.Dialog);
            View layout = inflater.inflate(R.layout.dialog_my, null);
            dialog.addContentView(layout, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            ((TextView) layout.findViewById(R.id.tv_dialog_title)).setText(title);
            imageView = (ImageView) layout.findViewById(R.id.iv);
            rl_left = (RelativeLayout)layout.findViewById(R.id.rl_left);
            tv_cancel = (TextView)layout.findViewById(R.id.tv_cancel);
            tv_verify = (TextView)layout.findViewById(R.id.tv_verify);
            tv_msg = (TextView)layout.findViewById(R.id.tv_dialog_content);
            if(drawable != 0){
                imageView.setBackgroundResource(drawable);
            }
            if(rl_left_isVisible){
                rl_left.setVisibility(View.VISIBLE);
            }else {
                rl_left.setVisibility(View.GONE);
            }
            if(tv_subTitle_isVisible){
                tv_msg.setVisibility(View.VISIBLE);
            }else {
                tv_msg.setVisibility(View.GONE);
            }
            if (positiveButtonText != null) {
                tv_cancel.setText(positiveButtonText);
                if (positiveButtonClickListener != null) {
                    tv_cancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    positiveButtonClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                                }
                            });
                }
            } else {
                tv_cancel.setVisibility(View.GONE);
            }
            if(!StringUtils.isNullOrEmpty(leftName)){
                tv_cancel.setText(leftName);
            }
            if(!StringUtils.isNullOrEmpty(rightName)){
                tv_verify.setText(rightName);
            }
            if (negativeButtonText != null) {
                tv_verify.setText(negativeButtonText);
                if (negativeButtonClickListener != null) {
                    tv_verify.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    negativeButtonClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
                                }
                            });
                }
            } else {
                tv_verify.setVisibility(View.GONE);
            }
            if (message != null) {
                tv_msg.setTypeface(TypeFaceUtils.initSpecialRegular(context));
               tv_msg.setText(message);
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
