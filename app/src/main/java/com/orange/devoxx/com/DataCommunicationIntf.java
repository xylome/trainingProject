package com.orange.devoxx.com;


import com.orange.devoxx.com.backend.beans.LoginResponse;

/**
 * Created by xylome on 28/04/2016.
 */
public interface DataCommunicationIntf {

    public LoginResponse login(String password, String email);
}
