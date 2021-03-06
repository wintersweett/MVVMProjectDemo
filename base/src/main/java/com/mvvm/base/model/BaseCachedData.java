package com.mvvm.base.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import androidx.annotation.Keep;

/**
* @author :WinterSweett
 * @description
 *
*/
@Keep
public class BaseCachedData<T> implements Serializable {
    @SerializedName("updateTimeInMillis")
    @Expose
    public long updateTimeInMills;

    @SerializedName("data")
    @Expose
    public T data;
}
