package com.orange.devoxx.service;

import com.orange.devoxx.service.group.GroupServiceIntf;
import com.orange.devoxx.service.login.LoginService;
import com.orange.devoxx.service.login.LoginServiceIntf;

import java.util.concurrent.ExecutorService;

/**
 * Created by xylome on 28/04/2016.
 */
public interface ServiceManagerIntf {
    public ExecutorService getCancelableThreadsExecutor() ;
    public LoginServiceIntf getLoginService() ;
    public GroupServiceIntf getGroupService();
}
