package com.orange.devoxx.service.group;

import android.util.Log;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.com.backend.beans.GroupResponse;
import com.orange.devoxx.dao.DaoManager;
import com.orange.devoxx.dao.group.GroupDaoIntf;
import com.orange.devoxx.injector.Injector;

import org.greenrobot.eventbus.EventBus;

import hugo.weaving.DebugLog;

/**
 * Created by xylome on 17/05/2016.
 */
public class GroupService implements GroupServiceIntf {


    private static final String TAG = "GroupService";
    private GroupResponse mGroupResponse;

    @Override
    public void getGroupsAsync() {
        MyApplication.instance.getServiceManager().getCancelableThreadsExecutor().submit(new GroupsRunnable());
    }

    @DebugLog
    private void getGroupsSync() {
        mGroupResponse = new GroupResponse();
        mGroupResponse.setGroups(DaoManager.getInstance().getGroupDao().getGroups());
        if (mGroupResponse.count() == 0) {
            mGroupResponse = Injector.getDataCommunication().myGroups();
            DaoManager.getInstance().getGroupDao().saveGroups(mGroupResponse.getGroups());
        }
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
