package com.mvvm.base.loadsir;

import com.kingja.loadsir.callback.Callback;
import com.mvvm.base.R;


/**
* @author :WinterSweett
 * @description emty情况处理
 *
*/

public class EmptyCallback extends Callback {

    @Override
    protected int onCreateView() {
        return R.layout.layout_empty_zouya;
    }

}
