package com.orange.devoxx;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.orange.devoxx.dao.DaoManagerIntf;

import com.orange.devoxx.data.DataManager;
import com.orange.devoxx.injector.Injector;
import com.orange.devoxx.service.ServiceManagerIntf;
import com.orange.devoxx.view.login.LoginActivity;
import com.orm.SugarContext;
import com.orm.SugarRecord;

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
        SugarContext.init(getApplicationContext());
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

    public final DataManager getDataManager() {
        return DataManager.getInstance(instance.getApplicationContext());
    }

    @Override
    public void onTerminate() {
        SugarContext.terminate();
        super.onTerminate();
        Log.d(TAG, "Application terminated");
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

    public void activityStopped() {
        mNbActivityAlive.set(mNbActivityAlive.get()-1);
        Log.d(TAG, "Alive activities:" + mNbActivityAlive.get());
        stopEverything();
    }


    public boolean isConnected() {
        return true;
    }
}