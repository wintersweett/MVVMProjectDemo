package com.mvvm.login.beans;

import java.io.Serializable;
import java.util.List;

public class LoginResult implements Serializable {

        private Data data;

        private int errorCode;

        private String errorMsg;

        public void setData(Data data){
            this.data = data;
        }
        public Data getData(){
            return this.data;
        }
        public void setErrorCode(int errorCode){
            this.errorCode = errorCode;
        }
        public int getErrorCode(){
            return this.errorCode;
        }
        public void setErrorMsg(String errorMsg){
            this.errorMsg = errorMsg;
        }
        public String getErrorMsg(){
            return this.errorMsg;
        }


    public class Data
    {
        private boolean admin;

        private List<String> chapterTops;

        private int coinCount;

        private List<String> collectIds;

        private String email;

        private String icon;

        private int id;

        private String nickname;

        private String password;

        private String publicName;

        private String token;

        private int type;

        private String username;

        public void setAdmin(boolean admin){
            this.admin = admin;
        }
        public boolean getAdmin(){
            return this.admin;
        }
        public void setChapterTops(List<String> chapterTops){
            this.chapterTops = chapterTops;
        }
        public List<String> getChapterTops(){
            return this.chapterTops;
        }
        public void setCoinCount(int coinCount){
            this.coinCount = coinCount;
        }
        public int getCoinCount(){
            return this.coinCount;
        }
        public void setCollectIds(List<String> collectIds){
            this.collectIds = collectIds;
        }
        public List<String> getCollectIds(){
            return this.collectIds;
        }
        public void setEmail(String email){
            this.email = email;
        }
        public String getEmail(){
            return this.email;
        }
        public void setIcon(String icon){
            this.icon = icon;
        }
        public String getIcon(){
            return this.icon;
        }
        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return this.id;
        }
        public void setNickname(String nickname){
            this.nickname = nickname;
        }
        public String getNickname(){
            return this.nickname;
        }
        public void setPassword(String password){
            this.password = password;
        }
        public String getPassword(){
            return this.password;
        }
        public void setPublicName(String publicName){
            this.publicName = publicName;
        }
        public String getPublicName(){
            return this.publicName;
        }
        public void setToken(String token){
            this.token = token;
        }
        public String getToken(){
            return this.token;
        }
        public void setType(int type){
            this.type = type;
        }
        public int getType(){
            return this.type;
        }
        public void setUsername(String username){
            this.username = username;
        }
        public String getUsername(){
            return this.username;
        }
    }
}
