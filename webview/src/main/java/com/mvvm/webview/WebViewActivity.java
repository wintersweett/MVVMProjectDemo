package com.mvvm.webview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.mvvm.base.activity.BaseActivity;
import com.mvvm.base.viewmodel.BaseViewModel;
import com.mvvm.webview.databinding.ActivityWebViewBinding;
import com.mvvm.webview.utils.Constants;

public class WebViewActivity extends BaseActivity<ActivityWebViewBinding, BaseViewModel> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding.title.setText(getIntent().getStringExtra(Constants.TITLE));
        viewDataBinding.actionBar.setVisibility(getIntent().getBooleanExtra(Constants.IS_SHOW_ACTION_BAR, true)? View.VISIBLE:View.GONE);
        viewDataBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewActivity.this.finish();
            }
        });
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = WebViewFragment.newInstance(getIntent().getStringExtra(Constants.URL), true);
        transaction.replace(R.id.web_view_fragment, fragment).commit();
    }

    @Override
    protected void onRetryBtnClick() {

    }

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_webview;
    }

    public void updateTitle(String title){
        viewDataBinding.title.setText(title);
    }
}