package com.orange.devoxx.com;


import com.orange.devoxx.com.backend.beans.GroupResponse;
import com.orange.devoxx.com.backend.beans.LoginResponse;

import hugo.weaving.DebugLog;

/**
 * Created by xylome on 28/04/2016.
 */
public class NotConnectedDataCommunication implements  DataCommunicationIntf{

    @DebugLog
    @Override
    public LoginResponse login(String password, String email) {
        return null;
    }

    @Override
    public GroupResponse myGroups() {
        return null;
    }
}
