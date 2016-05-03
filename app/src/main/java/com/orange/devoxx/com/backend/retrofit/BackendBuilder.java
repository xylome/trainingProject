package com.orange.devoxx.com.backend.retrofit;

import android.support.annotation.NonNull;
import android.util.Log;


import hugo.weaving.DebugLog;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xylome on 02/05/2016.
 */
public class BackendBuilder {
    private static final String TAG = "BackenBuilder";
    private static BackendService mBackendService = null;
    private static final String END_POINT = "https://www.chacunsapart.com/";

    @DebugLog
    @NonNull
    public static BackendService getBackendService() {
        if (null == mBackendService) {
            OkHttpClient client = getClient();
            Retrofit raCustom = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(END_POINT)
                    //You need to add a converter if you want your Json to be automagicaly convert into the object
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mBackendService = raCustom.create(BackendService.class);
        }
        return mBackendService;
    }

    @DebugLog
    public static OkHttpClient getClient() {
        HttpLoggingInterceptor httpLogInterceptor = new HttpLoggingInterceptor();
        httpLogInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(httpLogInterceptor).build();
    }
}