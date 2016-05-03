package com.orange.devoxx.dao;

import com.orange.devoxx.dao.login.LoginDao;
import com.orange.devoxx.dao.login.LoginDaoIntf;

/**
 * Created by xylome on 02/05/2016.
 */
public class DaoManager implements DaoManagerIntf{

    private static DaoManager mInstance = null;
    private LoginDaoIntf mLoginDaoIntf;


    public static DaoManager getInstance() {
        if (null == mInstance) {
            mInstance = new DaoManager();
        }
        return mInstance;
    }

    private DaoManager() {

    }

    public LoginDaoIntf getLoginDao() {
        if (mLoginDaoIntf == null) {
            mLoginDaoIntf = new LoginDao(this);
        }
        return mLoginDaoIntf;
    }

}
