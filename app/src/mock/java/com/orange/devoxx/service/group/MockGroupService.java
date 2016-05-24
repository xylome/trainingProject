package com.orange.devoxx.service.group;

import android.util.Log;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.com.backend.beans.Group;
import com.orange.devoxx.com.backend.beans.GroupResponse;
import com.orange.devoxx.injector.Injector;

import org.greenrobot.eventbus.EventBus;

import hugo.weaving.DebugLog;

/**
 * Created by xylome on 17/05/2016.
 */
public class MockGroupService implements GroupServiceIntf {
    private static final String TAG = "MockGroupService";
    private GroupResponse mGroupResponse;

    @DebugLog
    @Override
    public void getGroupsAsync() {
        //MyApplication.instance.getServiceManager().getCancelableThreadsExecutor().submit(new GroupsRunnable());
        getGroupsSync();
    }

    @DebugLog
    private void getGroupsSync() {
        //mGroupResponse = Injector.getDataCommunication().myGroups();
        Log.d(TAG, "group sync !!!!");
        Log.d(TAG, "GroupModelDeprecated pas sync !!");
        mGroupResponse = new GroupResponse();
        Log.d(TAG, "after new GroupResponse()");

        Group tmp = new Group();
        Log.d(TAG, "after new GroupModelDeprecated()");
        tmp.setName("Mock1");
        Log.d(TAG, "after setname()");

            mGroupResponse.addGroup(tmp);

        Log.d(TAG, "after addGroup()");

        Group tmp2 = new Group();
        tmp2.setName("Mock2");
         mGroupResponse.addGroup(tmp2);

        Log.d(TAG, "postons la réponse");
        postMyGroupsResponse();
    }

    @DebugLog
    private void postMyGroupsResponse() {
        EventBus.getDefault().post(mGroupResponse);
    }

    private class GroupsRunnable implements Runnable {

        @Override
        public void run() {
            getGroupsSync();
        }
    }

}
