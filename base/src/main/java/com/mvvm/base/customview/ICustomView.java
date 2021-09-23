package com.mvvm.base.customview;

/**
* @author :WinterSweett
 * @description
 *
*/
public interface ICustomView<S extends BaseCustomViewModel> {

    void setData(S data);

    void setStyle(int resId);

    void setActionListener(ICustomViewActionListener listener);

}
