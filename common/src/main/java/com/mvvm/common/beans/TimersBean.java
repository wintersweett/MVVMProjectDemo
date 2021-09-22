package com.mvvm.common.beans;

import com.contrarywind.interfaces.IPickerViewData;

import java.util.List;

import androidx.annotation.Keep;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
@Keep
public class TimersBean implements IPickerViewData {

        /**
         * dayName : 今天
         * hours : [{"hourName":"0点","minutes":["0分","30分"]},{"hourName":"1点","minutes":["0分","30分"]},{"hourName":"2点","minutes":["0分","30分"]},{"hourName":"3点","minutes":["0分","30分"]},{"hourName":"4点","minutes":["0分","30分"]},{"hourName":"5点","minutes":["0分","30分"]},{"hourName":"6点","minutes":["0分","30分"]},{"hourName":"7点","minutes":["0分","30分"]},{"hourName":"8点","minutes":["0分","30分"]},{"hourName":"9点","minutes":["0分","30分"]},{"hourName":"10点","minutes":["0分","30分"]},{"hourName":"11点","minutes":["0分","30分"]},{"hourName":"12点","minutes":["0分","30分"]},{"hourName":"13点","minutes":["0分","30分"]},{"hourName":"14点","minutes":["0分","30分"]},{"hourName":"15点","minutes":["0分","30分"]},{"hourName":"16点","minutes":["0分","30分"]},{"hourName":"17点","minutes":["0分","30分"]},{"hourName":"18点","minutes":["0分","30分"]},{"hourName":"19点","minutes":["0分","30分"]},{"hourName":"20点","minutes":["0分","30分"]},{"hourName":"21点","minutes":["0分","30分"]},{"hourName":"22点","minutes":["0分","30分"]},{"hourName":"23点","minutes":["0分","30分"]}]
         */

        private String dayName;
        private List<HoursBean> hours;

        public String getDayName() {
            return dayName;
        }

        public void setDayName(String dayName) {
            this.dayName = dayName;
        }

        public List<HoursBean> getHours() {
            return hours;
        }

        public void setHours(List<HoursBean> hours) {
            this.hours = hours;
        }

    @Override
    public String getPickerViewText() {
        return this.dayName;
    }
    @Keep
    public static class HoursBean {
            /**
             * hourName : 0点
             * minutes : ["0分","30分"]
             */

            private String hourName;
            private List<String> minutes;

            public String getHourName() {
                return hourName;
            }

            public void setHourName(String hourName) {
                this.hourName = hourName;
            }

            public List<String> getMinutes() {
                return minutes;
            }

            public void setMinutes(List<String> minutes) {
                this.minutes = minutes;
            }
        }
}
