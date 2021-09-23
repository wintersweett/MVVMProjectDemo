package com.mvvm.common.viewpageaddindicator;
/**
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
