package com.orange.devoxx.service;

import java.util.concurrent.ExecutorService;

/**
 * Created by xylome on 28/04/2016.
 */
public interface ServiceManagerIntf {
    public ExecutorService getCancelableThreadsExecutor() ;

}
