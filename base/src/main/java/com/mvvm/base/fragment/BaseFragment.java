package com.mvvm.base.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.components.SimpleImmersionOwner;
import com.gyf.immersionbar.components.SimpleImmersionProxy;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.mvvm.base.R;
import com.mvvm.base.loadsir.EmptyCallback;
import com.mvvm.base.loadsir.ErrorCallback;
import com.mvvm.base.loadsir.LottieLoadingCallback;
import com.mvvm.base.utils.DialogUtils;
import com.mvvm.base.utils.OnNoDoubleListener;
import com.mvvm.base.utils.ToastUtil;
import com.mvvm.base.utils.UtilsLog;
import com.mvvm.base.viewmodel.BaseViewModel;
import com.mvvm.base.viewmodel.ViewStatus;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/
public abstract class BaseFragment<V extends ViewDataBinding, VM extends BaseViewModel, D> extends OnNoDoubleListener implements Observer, SimpleImmersionOwner{
    protected VM viewModel;
    protected V viewDataBinding;
    private LoadService mLoadService;
    public abstract int getBindingVariable();

    public abstract
    @LayoutRes
    int getLayoutId();

    public abstract VM getViewModel();

    public abstract void onListItemInserted(ObservableList<D> sender);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        UtilsLog.d(getFragmentTag(), "Activity:" + getActivity() + " Fragment:"+this + ": " + "onCreate");
        initParameters();
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                   viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);

        UtilsLog.d("ws","BaseFragment:this:"+this);
//        if(savedInstanceState == null || viewDataBinding == null){
//            viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
//        } else {
//            viewDataBinding = (V) savedInstanceState.getSerializable("viewdatabinding");
//            UtilsLog.d(getFragmentTag(), "Activity:" + getActivity() + " Fragment:"+this + ": " + "savedInstanceState != null");
//        }
//        UtilsLog.d(getFragmentTag(), "Activity:" + getActivity() + " Fragment:"+this + ": " + "onCreateView");
        return viewDataBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewDataBinding = null ;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        UtilsLog.d(getFragmentTag(), "Activity:" + getActivity() + " Fragment:"+this + ": " + "onSaveInstanceState");
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        UtilsLog.d(getFragmentTag(), "Activity:" + getActivity() + " Fragment:"+this + ": " + "onViewCreated");
        viewModel = getViewModel();
        getLifecycle().addObserver(viewModel);
        viewModel.dataList.observe(this, this);
        viewModel.viewStatusLiveData.observe(this, this);
        if (getBindingVariable() > 0) {
            viewDataBinding.setVariable(getBindingVariable(), viewModel);
            setDataBindingVariables();
        }
        viewDataBinding.executePendingBindings();
    }
    protected void setDataBindingVariables(){

    }

    /***
     *   初始化参数
     */
    protected void initParameters() {
    }

    protected abstract void onRetryBtnClick();

    @Override
    public void onAttach(Context context) {
        super.onAttach(getContext());
        UtilsLog.d(getFragmentTag(), "Activity:" + getActivity() + " Fragment:"+this + ": " + "onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        UtilsLog.d(getFragmentTag(), "Activity:" + getActivity() + " Fragment:"+this + ": " + "onDetach");
    }

    @Override
    public void onStop() {
        super.onStop();
        UtilsLog.d(getFragmentTag(), "Activity:" + getActivity() + " Fragment:"+this + ": " + "onStop");
    }

    @Override
    public void onPause() {
        super.onPause();
        UtilsLog.d(getFragmentTag(), "Activity:" + getActivity() + " Fragment:"+this + ": " + "onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        UtilsLog.d(getFragmentTag(), "Activity:" + getActivity() + " Fragment:"+this + ": " + "onResume");
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

    protected abstract String getFragmentTag();

    @Override
    public void onChanged(Object o) {
        UtilsLog.d("zhm","onChanged : BaseFragment"+o);
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
                    if (((ObservableArrayList)viewModel.dataList.getValue()).size() == 0) {
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
        } else if(o instanceof ObservableArrayList) {
            onListItemInserted((ObservableArrayList<D>)o);
        }
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
    Dialog dialog;
    public void showDia(Context context){
        if(dialog == null || !dialog.isShowing()){
            StackTraceElement[] stackTraceElements =  new Throwable().getStackTrace();
            UtilsLog.d("zhm","Dialog show");
            UtilsLog.d("zhm","Dialog:stackTraceElements:"+stackTraceElements[0]+"\n"+stackTraceElements[1]);
            dialog = DialogUtils.showProcessDialog(getContext());
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



    /**
     * ImmersionBar代理类
     */
    private SimpleImmersionProxy mSimpleImmersionProxy = new SimpleImmersionProxy(this);

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        mSimpleImmersionProxy.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSimpleImmersionProxy.onActivityCreated(savedInstanceState);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mSimpleImmersionProxy.onDestroy();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        mSimpleImmersionProxy.onHiddenChanged(hidden);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mSimpleImmersionProxy.onConfigurationChanged(newConfig);
    }

    /**
     * 是否可以实现沉浸式，当为true的时候才可以执行initImmersionBar方法
     * Immersion bar enabled boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean immersionBarEnabled() {
        return true;
    }
}
