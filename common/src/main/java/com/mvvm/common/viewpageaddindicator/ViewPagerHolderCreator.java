package com.mvvm.common.viewpageaddindicator;
/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/
public interface ViewPagerHolderCreator<VH extends ViewPageHolder> {
    /**
     * @param:
    *创建viewholder
    */
    public VH createViewHolder();
}
