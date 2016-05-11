package com.orange.devoxx.injector;

import android.util.Log;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.com.DataCommunication;
import com.orange.devoxx.dao.DaoManager;
import com.orange.devoxx.service.ServiceManager;

/**
 * Created by xylome on 28/04/2016.
 */
public class Injector {
    private static final String TAG = "MockInjector";

    public static ServiceManager getServiceManager(MyApplication myApp) {
        Log.d(TAG, "Have to mock it now :)");
        return new ServiceManager(myApp);
    }

    public static DaoManager getDaoManager() {
        Log.d(TAG, "Have to mock it now :)");
        return DaoManager.getInstance();
    }

    public static DataCommunication getDataCommunication(){
        Log.d(TAG, "Have to mock it now :)");
        return DataCommunication.getInstance();
    }
}
