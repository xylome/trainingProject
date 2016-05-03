package com.orange.devoxx.com.backend.beans;

import com.google.gson.annotations.SerializedName;

public class LoginQuery {

    @SerializedName("email")
    private String mLogin;

    @SerializedName("password")
    private String mPassword;

    public LoginQuery(String login, String password) {
        mLogin = login;
        mPassword = password;
    }

}