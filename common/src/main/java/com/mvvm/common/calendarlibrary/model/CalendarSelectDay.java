package com.mvvm.common.calendarlibrary.model;

import java.io.Serializable;

/**
 * github:https://github.com/sy007
 */
public class CalendarSelectDay<K> implements Serializable {
    private K firstSelectDay;
    private K lastSelectDay;

    public K getFirstSelectDay() {
        return firstSelectDay;
    }

    public K getLastSelectDay() {
        return lastSelectDay;
    }

    public void setFirstSelectDay(K firstSelectDay) {
        this.firstSelectDay = firstSelectDay;
    }

    public void setLastSelectDay(K lastSelectDay) {
        this.lastSelectDay = lastSelectDay;
    }
}
