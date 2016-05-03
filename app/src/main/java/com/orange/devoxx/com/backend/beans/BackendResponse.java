package com.orange.devoxx.com.backend.beans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xylome on 02/05/2016.
 */
public class BackendResponse<T> {

    @SerializedName("data")
    private T data;
    private String status;

    public BackendResponse(BackendResponse<T> br) {
        data = br.getData();
        status = br.getStatus();
    }

    public T getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }
}
