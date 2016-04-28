package com.orange.devoxx.com;

import com.orange.devoxx.transverse.model.LoginResponse;

/**
 * Created by xylome on 28/04/2016.
 */
public interface DataCommunicationIntf {

    public LoginResponse login(String password, String email);
}
