package com.orange.devoxx.service;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.service.login.LoginService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by xylome on 28/04/2016.
 */
public class ServiceManager implements ServiceManagerIntf {

    private ExecutorService cancelableThreadsExecutor = null;

    private LoginService loginService;


    public  ServiceManager(MyApplication myApp) {

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
