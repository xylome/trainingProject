package com.orange.devoxx.com;

import android.test.AndroidTestCase;

import com.orange.devoxx.com.backend.beans.LoginResponse;
import com.orange.devoxx.injector.Injector;

/**
 * Created by xylome on 25/05/2016.
 */
public class DataCommunicationTest extends AndroidTestCase {

    private static final String TAG = "DataCommunicationTest";

    public void setUp() throws Exception {
        super.setUp();
        //Log.i(TAG, "Setup called !");
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testLogin() {
        assertEquals(200, 100+100);

        LoginResponse lr = Injector.getDataCommunication().login("xavier@chacunsapart.com", "64516451");
        assertEquals(lr.getNick(), "XylCSP");
    }


}
