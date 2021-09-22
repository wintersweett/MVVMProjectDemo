package com.mvvm.base.loadsir;

import com.kingja.loadsir.callback.Callback;
import com.mvvm.base.R;


/**
* @date :2020/10/20
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
