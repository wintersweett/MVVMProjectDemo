package com.mvvm.base.model;

/**
* @date :2020/10/20
* @author :WinterSweett
 * @description
 *
*/
public class PagingResult {
    public PagingResult(boolean isEmpty, boolean isFirstPage, boolean hasNextPage) {
        this.isEmpty = isEmpty;
        this.isFirstPage = isFirstPage;
        this.hasNextPage = hasNextPage;
    }

    public boolean isFirstPage;
    public boolean isEmpty;
    public boolean hasNextPage;
}
