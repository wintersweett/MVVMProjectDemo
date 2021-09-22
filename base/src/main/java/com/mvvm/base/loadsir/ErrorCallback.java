package com.mvvm.base.loadsir;

import com.kingja.loadsir.callback.Callback;
import com.mvvm.base.R;

/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/

public class ErrorCallback extends Callback {
    @Override
    protected int onCreateView() {
        return R.layout.layout_error;
    }
}
