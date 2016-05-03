package com.orange.devoxx.com.backend.retrofit;


import com.orange.devoxx.com.backend.beans.BackendResponse;
import com.orange.devoxx.com.backend.beans.LoginResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by xylome on 02/05/2016.
 */
public interface BackendService {
    @GET("json.php")
    Call<BackendResponse<LoginResponse>> login(@Query("action") String action, @Query("params") String login_params);
}
