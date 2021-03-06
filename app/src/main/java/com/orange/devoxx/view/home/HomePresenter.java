package com.orange.devoxx.view.home;

import android.util.Log;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.event.LoginResponseEvent;
import com.orange.devoxx.event.LogoutResponseEvent;
import com.orange.devoxx.injector.Injector;
import com.orange.devoxx.view.BaseActivityPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    @DebugLog
    @Subscribe
    public void onLogoutReceived(LogoutResponseEvent lre) {
        view.backToLogin();
    }


}
