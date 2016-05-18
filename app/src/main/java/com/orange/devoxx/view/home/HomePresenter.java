package com.orange.devoxx.view.home;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.com.backend.beans.GroupResponse;
import com.orange.devoxx.event.LogoutResponseEvent;
import com.orange.devoxx.view.BaseActivityPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import hugo.weaving.DebugLog;

/**
 * Created by xylome on 25/04/2016.
 */
public class HomePresenter extends BaseActivityPresenter<HomeView> {


    private static final String TAG = "HomePresenter" ;

    @DebugLog
    protected HomePresenter(HomeView view) {
        super(view);
    }

    @DebugLog
    @Override
    public void unsubscribe() {
        EventBus.getDefault().unregister(this);
    }

    @DebugLog
    @Override
    public void subscrible() {
        EventBus.getDefault().register(this);
    }

    public void logout() {
        MyApplication.instance.getServiceManager().getLoginService().logoutAsync();
    }

    public void myGroups() {
        MyApplication.instance.getServiceManager().getGroupService().getGroupsAsync();
    }

    @DebugLog
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMyGroups(GroupResponse gr) {
        view.groupsUpated(gr);
    }

    @DebugLog
    @Subscribe
    public void onLogoutReceived(LogoutResponseEvent lre) {
        view.backToLogin();
    }


}
