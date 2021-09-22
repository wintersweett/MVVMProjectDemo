package com.mvvm.net.api;


import com.mvvm.net.beans.RefreshTokenResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public interface RefreshTokenInterface {
    //刷新token
    @GET("/rentcar/api/u/user/refreshToken/v2")
    Observable<RefreshTokenResponse> getToken(@Query("refreshToken") String refreshToken );
}
