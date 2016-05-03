package com.orange.devoxx.com.backend.beans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xylome on 02/05/2016.
 */
public class LoginResponse {
    @SerializedName("acct_id")
    private String mAccountId;
    @SerializedName("nick")
    private String mNick;
    @SerializedName("actor_id")
    private String mActorId;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("auth_cookie")
    private String mAuthCookie;


    public LoginResponse(LoginResponse lr) {
        mAccountId = lr.getAccountId();
        mNick = lr.getNick();
        mActorId = lr.getActorId();
        mEmail = lr.getEmail();
        mAuthCookie = lr.getAuthCookie();
    }


    public String getAccountId() {
        return mAccountId;
    }

    public String getNick() {
        return mNick;
    }

    public String getActorId() {
        return mActorId;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getAuthCookie() {
        return mAuthCookie;
    }
}
