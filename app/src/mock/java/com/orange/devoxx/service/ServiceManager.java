package com.orange.devoxx.service;

import android.util.Log;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.service.group.GroupService;
import com.orange.devoxx.service.group.GroupServiceIntf;
import com.orange.devoxx.service.group.MockGroupService;
import com.orange.devoxx.service.login.LoginService;
import com.orange.devoxx.service.login.LoginServiceIntf;
import com.orange.devoxx.service.login.MockLoginService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import hugo.weaving.DebugLog;

/**
 * Created by xylome on 28/04/2016.
 */
public class ServiceManager implements ServiceManagerIntf {

    private static final String TAG = "ServiceManager";
    private ExecutorService cancelableThreadsExecutor = null;

    private LoginServiceIntf loginService;
    private GroupServiceIntf groupService;

    @DebugLog
    public  ServiceManager(MyApplication myApp) {

    }

    public final LoginServiceIntf getLoginService() {
        if (null == loginService) {
            Log.d(TAG, "serving a new MockLoginService");
            loginService = new MockLoginService();
        }
        return loginService;
    }

    public final GroupServiceIntf getGroupService() {
        if (null == groupService) {
            Log.d(TAG, "serving a new ----- MockGroupService");
            groupService = new MockGroupService();
        }
        return groupService;
    }

    /**
     * @return the cancelableThreadsExceutor
     */
    @Override
    public final ExecutorService getCancelableThreadsExecutor() {
        if (cancelableThreadsExecutor == null) {
            cancelableThreadsExecutor = Executors.newFixedThreadPool(12, new CancelableThreadFactory());
        }
        return cancelableThreadsExecutor;
    }

    /** * And its associated factory */
    private class CancelableThreadFactory implements ThreadFactory {
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("CancelableThread"+((int)(Math.random()*1000)));
            return t;
        }
    }

}
