package com.mvvm.common.calendarlibrary;

import java.lang.ref.WeakReference;

import androidx.annotation.Keep;

import com.mvvm.common.calendarlibrary.model.CalendarDay;
import com.mvvm.common.calendarlibrary.model.CalendarSelectDay;

/**
 * github:https://github.com/sy007
 */

public class CalendarViewWrapper {

    public static CalendarBuilder wrap(CalendarView calendarView) {
        return new CalendarBuilder(calendarView);
    }
    @Keep
    public static class CalendarBuilder {
        java.util.Date minDate, maxDate;
        SelectionMode selectionMode;
        MonthTitleViewCallBack monthTitleViewCallBack;
        boolean isStick = true;
        boolean isShowMonthTitleView;
        OnCalendarSelectDayListener<CalendarDay> onCalendarSelectDayListener;
        CalendarSelectDay<CalendarDay> calendarSelectDay;
        WeakReference<CalendarView> weakReference;


        public CalendarBuilder(CalendarView calendarView) {
            this.weakReference = new WeakReference<>(calendarView);
        }

        public CalendarBuilder setDateRange(java.util.Date minDate, java.util.Date maxDate) {
            this.minDate = minDate;
            this.maxDate = maxDate;
            return this;
        }

        public CalendarBuilder setSelectionMode(SelectionMode selectionMode) {
            this.selectionMode = selectionMode;
            return this;
        }

        public CalendarBuilder setMonthTitleViewCallBack(MonthTitleViewCallBack monthTitleViewCallBack) {
            this.monthTitleViewCallBack = monthTitleViewCallBack;
            return this;
        }

        public CalendarBuilder setShowMonthTitleView(boolean isShowMonthTitleView) {
            this.isShowMonthTitleView = isShowMonthTitleView;
            return this;
        }

        public CalendarBuilder setStick(boolean isStick) {
            this.isStick = isStick;
            return this;
        }


        public CalendarBuilder setOnCalendarSelectDayListener(com.mvvm.common.calendarlibrary.OnCalendarSelectDayListener<CalendarDay> onCalendarSelectDayListener) {
            this.onCalendarSelectDayListener = onCalendarSelectDayListener;
            return this;

        }

        public CalendarBuilder setCalendarSelectDay(CalendarSelectDay<CalendarDay> calendarSelectDay) {
            this.calendarSelectDay = calendarSelectDay;
            return this;
        }

        public void display() {
            weakReference.get().display(this);
        }
    }
}
