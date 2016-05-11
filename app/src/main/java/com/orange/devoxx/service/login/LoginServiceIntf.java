package com.orange.devoxx.service.login;

/**
 * Created by xylome on 29/04/2016.
 */
public interface LoginServiceIntf {
    public void loginAsync(String login, String password);
    public void logoutAsync();
}
