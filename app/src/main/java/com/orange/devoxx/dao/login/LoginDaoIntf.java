package com.orange.devoxx.dao.login;

import android.content.Context;

import com.orange.devoxx.com.backend.beans.LoginResponse;

/**
 * Created by xylome on 02/05/2016.
 */
public interface LoginDaoIntf {
    void saveLoginInfo(LoginResponse lr);

}
