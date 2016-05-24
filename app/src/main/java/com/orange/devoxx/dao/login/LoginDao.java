package com.orange.devoxx.dao.login;


import android.util.Log;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.com.backend.beans.LoginResponse;
import com.orange.devoxx.dao.DaoManager;
import com.orange.devoxx.dao.model.LoginInfo;

import hugo.weaving.DebugLog;


/**
 * Created by xylome on 02/05/2016.
 */
public class LoginDao implements LoginDaoIntf {

    public LoginDao(DaoManager dao) {}

    @DebugLog
    @Override
    public void saveLoginInfo(LoginResponse lr) {


    }
}
