package com.orange.devoxx.view.login;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.event.LoginResponseEvent;
import com.orange.devoxx.view.BaseActivityPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import hugo.weaving.DebugLog;

/**
 * Created by xylome on 03/05/2016.
 */
public class LoginPresenter extends BaseActivityPresenter<LoginView> {

    private static final String TAG = "LoginPresenter" ;

    protected LoginPresenter(LoginView view) {
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

    protected void login(String login, String password) {
        MyApplication.instance.getServiceManager().getLoginService().loginAsync(login, password);
    }

    @DebugLog
    @Subscribe
    public void loginReceived(LoginResponseEvent lre) {
        if (null != lre.getLoginResponse()) {
            view.loginOk();
        }
    }

}
