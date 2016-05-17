package com.orange.devoxx.service.group;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.com.backend.beans.GroupResponse;
import com.orange.devoxx.injector.Injector;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by xylome on 17/05/2016.
 */
public class GroupService implements GroupServiceIntf {


    private GroupResponse mGroupResponse;

    @Override
    public void getGroupsAsync() {
        MyApplication.instance.getServiceManager().getCancelableThreadsExecutor().submit(new GroupsRunnable());
    }


    private void getGroupsSync() {
        mGroupResponse = Injector.getDataCommunication().myGroups();
        postMyGroupsResponse();
    }

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
