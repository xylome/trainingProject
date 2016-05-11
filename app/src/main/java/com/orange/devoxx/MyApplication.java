package com.orange.devoxx;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.orange.devoxx.dao.DaoManagerIntf;

import com.orange.devoxx.injector.Injector;
import com.orange.devoxx.service.ServiceManagerIntf;
import com.orange.devoxx.view.login.LoginActivity;

import java.util.concurrent.atomic.AtomicInteger;

public class MyApplication extends Application {

    private final String TAG = "Application";
    public static MyApplication instance;
    private AtomicInteger mNbActivityAlive = new AtomicInteger(0);
    private Runnable myRunnable;
    private Handler myHandler;
    private Object mUserInfos;

    private ServiceManagerIntf mServiceManagerIntf;
    private DaoManagerIntf mDaoManagerIntf;

    // Vysor for android display

    @Override
    public void onCreate() {
        super.onCreate();
        setupSendActivityRunnable();
        setupSendActivityHandler();
        instance = this;
        mUserInfos = null;
        Log.d(TAG, "Application created");
    }

    public final ServiceManagerIntf getServiceManager() {
        if (null == mServiceManagerIntf) {
            mServiceManagerIntf = Injector.getServiceManager(this);
        }
        return mServiceManagerIntf;
    }

    public final DaoManagerIntf getDaoManager() {
        if (null == mDaoManagerIntf) {
            mDaoManagerIntf = Injector.getDaoManager();
        }
        return mDaoManagerIntf;
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "Application terminated");
    }

    synchronized public int getFoo() {
        return 42;
    }

    synchronized public void requestNick(Context c) {
        startActivity(LoginActivity.getIntent(c));
    }

    public void activityStarted() {
        mNbActivityAlive.set(mNbActivityAlive.get()+1);
        Log.d(TAG, "Alive activities:" + mNbActivityAlive.get());
    }

    private void setupSendActivityHandler() {
        myHandler = new Handler();
    }

    private void setupSendActivityRunnable() {
        myRunnable = new Runnable() {
            @Override
            public void run() {
                if (mNbActivityAlive.get() == 0) {
                    Log.d(TAG, "kill everyone");
                } else {
                    Log.d(TAG, "kill no one !!");
                }
            }
        };
    }

    private void stopEverything() {
        myHandler.postDelayed(myRunnable, 5000);
    }

    synchronized public Object getUserInfos() {
        return mUserInfos;
    }

    public void activityStopped() {
        mNbActivityAlive.set(mNbActivityAlive.get()-1);
        Log.d(TAG, "Alive activities:" + mNbActivityAlive.get());
        stopEverything();
    }


    public boolean isConnected() {
        return true;
    }
}