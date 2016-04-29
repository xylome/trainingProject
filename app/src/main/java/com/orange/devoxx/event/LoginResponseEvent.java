package com.orange.devoxx.event;

import com.orange.devoxx.transverse.model.LoginResponse;

/**
 * Created by xylome on 29/04/2016.
 */
public class LoginResponseEvent {

    private LoginResponse mResponse;

    public LoginResponseEvent(LoginResponse lr) {
        mResponse = lr;
    }

    public LoginResponse getLoginResponse() {
        return mResponse;
    }

}
