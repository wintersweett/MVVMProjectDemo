package com.mvvm.othermodule.otherpage.api;

import com.mvvm.othermodule.otherpage.beans.Root;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface2 {
    @GET("/article/list/0/json")
    Observable<Root> getArticleList();
}
