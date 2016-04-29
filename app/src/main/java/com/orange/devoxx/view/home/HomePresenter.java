package com.orange.devoxx.view.home;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.event.LoginResponseEvent;
import com.orange.devoxx.view.BaseActivityPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xylome on 25/04/2016.
 */
public class HomePresenter extends BaseActivityPresenter<HomeView> {



    protected HomePresenter(HomeView view) {
        super(view);
        EventBus.getDefault().register(this);
    }

    public void onButtonClicked(String foo) {
        String enriched = "enriched from presenter + " + foo;
        view.displayLog(enriched);
    }

    public void login(String login, String password) {
        MyApplication.instance.getServiceManager().getLoginService().loginAsync(login, password);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void loginReceived(LoginResponseEvent lr) {
        view.displayNick(lr.getLoginResponse().getNick());
    }

}
