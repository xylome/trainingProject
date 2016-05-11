package com.orange.devoxx.injector;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.com.DataCommunication;
import com.orange.devoxx.dao.DaoManager;
import com.orange.devoxx.service.ServiceManager;

/**
 * Created by xylome on 28/04/2016.
 */
public class Injector {
    public static ServiceManager getServiceManager(MyApplication myApp) {
        return new ServiceManager(myApp);
    }

    public static DaoManager getDaoManager() {
        return DaoManager.getInstance();
    }

    public static DataCommunication getDataCommunication(){
        return DataCommunication.getInstance();
    }
}
