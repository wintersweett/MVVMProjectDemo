package com.mvvm.base.customview;

import android.view.View;
/**
* @author :WinterSweett
 * @description
 *
*/
public interface ICustomViewActionListener {
    String ACTION_ROOT_VIEW_CLICKED = "action_root_view_clicked";

    void onAction(String action, View view, BaseCustomViewModel viewModel);
}
