package com.mvvm.login.api;

import com.mvvm.login.beans.LoginResult;


import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @POST("/user/login")
    Observable<LoginResult> login(@Query("username") String userName, @Query("password") String passWord) ;

}
