package com.mvvm.base.loadsir;

import android.content.Context;
import android.view.View;

import com.kingja.loadsir.callback.Callback;
import com.mvvm.base.R;

/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/

public class LottieLoadingCallback extends Callback {

    @Override
    protected int onCreateView() {
        return R.layout.layout_lottie_loading_zouya;
    }

    @Override
    protected boolean onReloadEvent(Context context, View view) {
        return true;
    }
}
