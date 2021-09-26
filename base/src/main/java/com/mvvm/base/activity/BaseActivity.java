package com.mvvm.base.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.ImmersionBar;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.mvvm.base.R;
import com.mvvm.base.databinding.ActivityBaseBinding;
import com.mvvm.base.loadsir.EmptyCallback;
import com.mvvm.base.loadsir.ErrorCallback;
import com.mvvm.base.loadsir.LottieLoadingCallback;
import com.mvvm.base.permission.PermissionManager;
import com.mvvm.base.permission.listener.PermissionCallback;
import com.mvvm.base.preference.BasicDataPreferenceUtil;
import com.mvvm.base.utils.AppManager;
import com.mvvm.base.utils.PermissionConstant;
import com.mvvm.base.utils.ToastUtil;
import com.mvvm.base.utils.UtilsLog;
import com.mvvm.base.viewmodel.BaseViewModel;
import com.mvvm.base.viewmodel.ViewStatus;

import java.util.List;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;


/**
* @author :WinterSweett
 * @description
 *
*/
public abstract class BaseActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity implements Observer, PermissionCallback {
    protected VM viewModel;
    private LoadService mLoadService;
    protected V viewDataBinding;
    public static String TAG ;
    protected void initImmersionBar() {
        //设置共同沉浸式样式
        ImmersionBar.with(this)
                .statusBarDarkFont(true) //状态栏字体是深色不写亮色
                .autoDarkModeEnable(true)
                .autoStatusBarDarkModeEnable(true,0.2f)
                .navigationBarColor(R.color.header_cloud_bg).init();
    }
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        TAG = getClass().getSimpleName() ;
        UtilsLog.d(TAG,TAG);
        //初始化沉浸式
        initImmersionBar();
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);
        initViewModel();
        performDataBinding();
        if(viewModel != null) {
            //BaseActivity是被观察者  viewmodel是观察者 ,这个方法将被观察者与观察者绑定
            getLifecycle().addObserver(viewModel);
        }
        ARouter.getInstance().inject(this);

        viewModel.viewStatusLiveData.observe(this,this);
    }

    private void initViewModel() {
        viewModel = getViewModel();
    }

    public void setLoadSir(View view) {
        // You can change the callback on sub thread directly.
        mLoadService = LoadSir.getDefault().register(view, new Callback.OnReloadListener() {
            @Override
            public void onReload(View v) {
                onRetryBtnClick();
            }
        });
    }
    protected abstract void onRetryBtnClick();

    protected abstract VM getViewModel();

    public abstract int getBindingVariable();

    public abstract
    /**
     * @param:[]
    *资源layout
    */
    @LayoutRes
    int getLayoutId();
    ActivityBaseBinding baseBinding ;
    private void performDataBinding() {
        baseBinding = DataBindingUtil.setContentView(this, R.layout.activity_base);
        initHeaderData();
        viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(this),
                getLayoutId(),
                baseBinding.framLayout ,true);
       // viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.viewModel = viewModel == null ? getViewModel() : viewModel;
        if (getBindingVariable() > 0) {
            viewDataBinding.setVariable(getBindingVariable(), viewModel);
        }
        setDataBindingVariables();
        viewDataBinding.executePendingBindings();
    }
 /**
  * @param:
 * 封装header 标题以及返回按钮的逻辑
 */
    private  void initHeaderData(){
        headerListener();
    }

    ImageView iv_back ;
    public TextView tv_title  ;
    protected void headerListener(){
        tv_title= baseBinding.headerCommon.findViewById(R.id.tv_title) ;
        iv_back = baseBinding.headerCommon.findViewById(R.id.iv_back);
        if(this.isHasTitleBar()){
            baseBinding.headerCommon.setVisibility(View.VISIBLE);
            setTitle();
        }else {
            baseBinding.headerCommon.setVisibility(View.GONE);
        }
        iv_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isGoBackFinish()){
                    finish();
                }else {
                    goBack();
                }

            }
        });
    }

    /**
     * @param:
    *  钩子方法 默认true，如果子类由其他业务逻辑，需要overrid 为false
     *  注意如果返回按钮要实现实现类自己的业务逻辑：overwrite isGoBackFinish 返回false ，然后在goBack方法中写自己的业务逻辑
    */
  protected boolean isGoBackFinish(){
        return true ;
  }
  /**
   * @param:
  *由子类去实现 是finish 还是其他业务逻辑
  */
    protected void goBack(){

    }


    /**
     * @param:
    * 修改标题
    */
    protected void setTitle(){
      UtilsLog.d("ws","base:setTitle:");
    }

    /**
     * @param: 钩子方法
    * 有子类实现是否有titlebar
    */
    protected boolean isHasTitleBar(){
        return true ;
    }

    protected void setDataBindingVariables(){

    }

    @Override
    public void onChanged(Object o) {
        if (o instanceof ViewStatus && mLoadService != null) {
            switch ((ViewStatus) o) {
                case LOADING:
                    mLoadService.showCallback(LottieLoadingCallback.class);
                    break;
                case EMPTY:
                    mLoadService.showCallback(EmptyCallback.class);
                    break;
                case SHOW_CONTENT:
                    mLoadService.showSuccess();
                    break;
                case NO_MORE_DATA:
                    ToastUtil.show(getString(R.string.no_more_data));
                    break;
                case REFRESH_ERROR:
                    if (((ObservableArrayList) viewModel.dataList.getValue()).size() == 0) {
                        mLoadService.showCallback(ErrorCallback.class);
                    } else {
                        ToastUtil.show(viewModel.errorMessage.getValue().toString());
                    }
                    break;
                case LOAD_MORE_FAILED:
                    ToastUtil.show(viewModel.errorMessage.getValue().toString());
                    break;
                default:
            }
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        UtilsLog.d(getActivityTag(), "Activity:" + this + ": " + "onStop");
    }

    @Override
    public void onPause() {
        super.onPause();
        UtilsLog.d(getActivityTag(), "Activity:" + this + ": " + "onPause");

    }

    @Override
    public void onResume() {
        super.onResume();
        UtilsLog.d(getActivityTag(), "Activity:" + this + ": " + "onResume");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(viewModel != null){
            getLifecycle().removeObserver(viewModel);
        }
       AppManager.getInstance().removeActivity(this);
        UtilsLog.d(getActivityTag(), "Activity:" + this + ": " + "onDestroy");
        cancelDia(this);
    }

    protected String getActivityTag() {
        return this.getClass().getSimpleName();
    }
    protected void showSuccess() {
        if (mLoadService != null) {
            mLoadService.showSuccess();
        }
    }

    protected void showLoading() {
        if (mLoadService != null) {
            mLoadService.showCallback(LottieLoadingCallback.class);
        }
    }
    protected void showError(){
        if (mLoadService != null) {
            mLoadService.showCallback(ErrorCallback.class);
        }
    }
    protected void showEmpty(){
        if (mLoadService != null) {
            mLoadService.showCallback(EmptyCallback.class);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AppManager.getInstance().remove(getViewModel());
    }
    Dialog dialog;
    public void showDia(Context context){
        if(dialog == null || !dialog.isShowing()){
          StackTraceElement[] stackTraceElements =  new Throwable().getStackTrace();
            dialog = com.mvvm.base.utils.DialogUtils.showProcessDialog(this);
            dialog.setOnDismissListener(new OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    dialog.dismiss();
                }
            });
        }
    }
    public void cancelDia(Context context){
        if(dialog != null){
            dialog.dismiss();
        }
    }

    @Override
    public boolean moveTaskToBack(boolean nonRoot) {
        return super.moveTaskToBack(true);
    }

    @Override
    public void onPermissionGranted(int requestCode, List<String> perms) {
        UtilsLog.d("ws","权限onPermissionGranted:requestCode:"+requestCode);
        BasicDataPreferenceUtil.getInstance().setInt(PermissionConstant.REQUEST_CODE_PERMISSION_GRANTED,requestCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.onRequestPermissionResult(requestCode,permissions,grantResults,this);
    }

    @Override
    public void onPermissionDenied(int requestCode, List<String> perms) {
        BasicDataPreferenceUtil.getInstance().setInt(PermissionConstant.REQUEST_CODE_PERMISSION_DENIED,requestCode);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(getParent() != null){
                getParent().onKeyDown(keyCode,event);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
