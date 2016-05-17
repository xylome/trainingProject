package com.orange.devoxx.com;

import android.util.Log;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.com.backend.beans.BackendResponse;
import com.orange.devoxx.com.backend.beans.GroupResponse;
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
    Call<GroupResponse> mGroupResponse;
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
            return mLoginResponse.execute().body().getData();

        } catch (Exception e) {
            Log.e(TAG, "Exception with retrofit: " + e.getMessage());
        }
        return lr;
    }

    @Override
    public GroupResponse myGroups() {

        String cookie = null;
        String my_groups_params = null;
        int account_id;

        cookie = MyApplication.instance.getDataManager().getCookie();
        account_id = Integer.parseInt(MyApplication.instance.getDataManager().getAccountId());

        my_groups_params = BackendQuery.myGroups(account_id);
        try {
            mGroupResponse = mBackendService.myGroups("my_groups", my_groups_params, cookie);
            return mGroupResponse.execute().body();
        } catch (Exception e) {
            Log.e(TAG, "Exception retrofit: " + e.getMessage());
        }
        return null;
    }


}
