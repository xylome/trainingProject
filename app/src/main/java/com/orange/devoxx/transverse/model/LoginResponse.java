package com.orange.devoxx.transverse.model;

/**
 * Created by xylome on 28/04/2016.
 */
public class LoginResponse {

    private String mNick;
    private String mEmail;

    public LoginResponse() {

    }

    public LoginResponse(String nick, String email) {
        mNick = nick;
        mEmail = email;
    }

    public String getNick() {
        return mNick;
    }

    public String getEmail() {
        return mEmail;
    }
}
