package com.mvvm.base.customview;

/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/
public interface ICustomView<S extends BaseCustomViewModel> {

    void setData(S data);

    void setStyle(int resId);

    void setActionListener(ICustomViewActionListener listener);

}
