package com.orange.devoxx.dao;


import com.orange.devoxx.dao.login.LoginDaoIntf;

/**
 * Created by xylome on 02/05/2016.
 */
public interface DaoManagerIntf {
    public LoginDaoIntf getLoginDao();

}
