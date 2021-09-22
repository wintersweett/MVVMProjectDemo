package com.mvvm.net.beans;

import androidx.annotation.Keep;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
@Keep
public class RefreshTokenResponse extends BaseResponse {

    /**
     * data : {"channelId":null,"userId":null,"phoneNumber":null,"nickName":null,"headPortrait":null,"certificationStatus":null,"token":"eyJhbGciOiJIUzUxMiJ9.eyJ1aWQiOjEwNDU0NjIsImFpZCI6IjZlNjJmZmFlMWVlNDRiOTdhYzMyYTBkM2RjOWZhNjJmIiwibGlkIjoiMTMwNTE3OTg4MzkiLCJsdHkiOjIsImRpZCI6IiIsImR0eSI6MCwicGlkIjoid2x4eWN4Iiwib3BpZCI6InVwbG9hZCx6aHNxLHFpbmcyIiwianRpIjoiYTkxZTY1OWYtYzQ2NS00NWEyLWFlNWQtZGI5OGUwNWUyMDFmIiwicnRpIjoiNWEyMTE1YjUtZTRmYS00YmU4LWEyZTYtMzYxMDZhNTYzMjlhIiwiZXhwIjoxNTk2MDg4ODE0fQ.Kjfe_gvoIv4yXiPzOcNJIcTVJHy4SMs_uDttkMXLNGk03cL-g6FRDtVqiJtQ3LTGXEY2ppHjeS0A5-jFhEMdGw","registerTime":null,"refreshToken":null,"uid":null,"aid":null,"cityId":null,"cityName":null,"autograph":null,"gender":null,"lastLoginTime":null}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }
    @Keep
    public static class DataBean {
        /**
         * channelId : null
         * userId : null
         * phoneNumber : null
         * nickName : null
         * headPortrait : null
         * certificationStatus : null
         * token : eyJhbGciOiJIUzUxMiJ9.eyJ1aWQiOjEwNDU0NjIsImFpZCI6IjZlNjJmZmFlMWVlNDRiOTdhYzMyYTBkM2RjOWZhNjJmIiwibGlkIjoiMTMwNTE3OTg4MzkiLCJsdHkiOjIsImRpZCI6IiIsImR0eSI6MCwicGlkIjoid2x4eWN4Iiwib3BpZCI6InVwbG9hZCx6aHNxLHFpbmcyIiwianRpIjoiYTkxZTY1OWYtYzQ2NS00NWEyLWFlNWQtZGI5OGUwNWUyMDFmIiwicnRpIjoiNWEyMTE1YjUtZTRmYS00YmU4LWEyZTYtMzYxMDZhNTYzMjlhIiwiZXhwIjoxNTk2MDg4ODE0fQ.Kjfe_gvoIv4yXiPzOcNJIcTVJHy4SMs_uDttkMXLNGk03cL-g6FRDtVqiJtQ3LTGXEY2ppHjeS0A5-jFhEMdGw
         * registerTime : null
         * refreshToken : null
         * uid : null
         * aid : null
         * cityId : null
         * cityName : null
         * autograph : null
         * gender : null
         * lastLoginTime : null
         */

        private Object channelId;
        private Object userId;
        private Object phoneNumber;
        private Object nickName;
        private Object headPortrait;
        private Object certificationStatus;
        private String token;
        private Object registerTime;
        private Object refreshToken;
        private Object uid;
        private Object aid;
        private Object cityId;
        private Object cityName;
        private Object autograph;
        private Object gender;
        private Object lastLoginTime;

        public Object getChannelId() {
            return channelId;
        }

        public void setChannelId(Object channelId) {
            this.channelId = channelId;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public Object getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(Object phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Object getNickName() {
            return nickName;
        }

        public void setNickName(Object nickName) {
            this.nickName = nickName;
        }

        public Object getHeadPortrait() {
            return headPortrait;
        }

        public void setHeadPortrait(Object headPortrait) {
            this.headPortrait = headPortrait;
        }

        public Object getCertificationStatus() {
            return certificationStatus;
        }

        public void setCertificationStatus(Object certificationStatus) {
            this.certificationStatus = certificationStatus;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Object getRegisterTime() {
            return registerTime;
        }

        public void setRegisterTime(Object registerTime) {
            this.registerTime = registerTime;
        }

        public Object getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(Object refreshToken) {
            this.refreshToken = refreshToken;
        }

        public Object getUid() {
            return uid;
        }

        public void setUid(Object uid) {
            this.uid = uid;
        }

        public Object getAid() {
            return aid;
        }

        public void setAid(Object aid) {
            this.aid = aid;
        }

        public Object getCityId() {
            return cityId;
        }

        public void setCityId(Object cityId) {
            this.cityId = cityId;
        }

        public Object getCityName() {
            return cityName;
        }

        public void setCityName(Object cityName) {
            this.cityName = cityName;
        }

        public Object getAutograph() {
            return autograph;
        }

        public void setAutograph(Object autograph) {
            this.autograph = autograph;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Object getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(Object lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }
    }
}
