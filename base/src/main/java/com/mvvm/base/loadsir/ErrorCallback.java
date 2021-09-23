package com.mvvm.base.loadsir;

import com.kingja.loadsir.callback.Callback;
import com.mvvm.base.R;

/**
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
