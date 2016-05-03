package com.orange.devoxx.com;

import android.util.Log;

import com.orange.devoxx.com.backend.beans.BackendResponse;
import com.orange.devoxx.com.backend.beans.LoginResponse;
import com.orange.devoxx.com.backend.retrofit.BackendBuilder;
import com.orange.devoxx.com.backend.retrofit.BackendQuery;
import com.orange.devoxx.com.backend.retrofit.BackendService;


import hugo.weaving.DebugLog;
import retrofit2.Call;

/**
 * Created by xylome on 28/04/2016.
 */
public class ConnectedDataCommunication implements DataCommunicationIntf{

    private static final String TAG = "ConnectedDataComm";
    BackendService mBackendService;

    Call<BackendResponse<LoginResponse>> mLoginResponse;

    @DebugLog
    public ConnectedDataCommunication() {
        mBackendService = BackendBuilder.getBackendService();
    }

    @DebugLog
    @Override
    public LoginResponse login(String login, String password) {
        LoginResponse lr = null;

        try {
            mLoginResponse = mBackendService.login("login", BackendQuery.login(login, password));
            //return new LoginResponse(mLoginResponse.execute().body());
            return mLoginResponse.execute().body().getData();

        } catch (Exception e) {
            Log.d(TAG, "Exception with retrofit: " + e.getMessage());
        }
        return lr;
    }
}
