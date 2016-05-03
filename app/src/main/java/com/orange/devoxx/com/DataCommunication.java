package com.orange.devoxx.com;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.com.backend.beans.LoginResponse;

import hugo.weaving.DebugLog;

/**
 * Created by xylome on 28/04/2016.
 */
public class DataCommunication implements DataCommunicationIntf {

    private DataCommunicationIntf mCommunication;

    private static DataCommunication mInstance;

    @DebugLog
    private DataCommunication() {
        if (MyApplication.instance.isConnected()) {
            mCommunication = new ConnectedDataCommunication();
        } else {
            mCommunication = new NotConnectedDataCommunication();
        }
    }

    public static DataCommunication getInstance() {
        if (null == mInstance) {
            mInstance = new DataCommunication();
        }
        return mInstance;
    }

    @DebugLog
    @Override
    public LoginResponse login(String email, String password) {
        return mCommunication.login(email, password);
    }
}
