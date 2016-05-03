package com.orange.devoxx.view.login;

import android.util.Log;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.event.GroupResultEvent;
import com.orange.devoxx.event.LoginResponseEvent;
import com.orange.devoxx.view.BaseActivityPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import hugo.weaving.DebugLog;

/**
 * Created by xylome on 03/05/2016.
 */
public class LoginPresenter extends BaseActivityPresenter<LoginView> {

    private static final String TAG = "LoginPresenter" ;

    protected LoginPresenter(LoginView view) {
        super(view);
        EventBus.getDefault().register(this);

    }

    protected void login(String login, String password) {
        MyApplication.instance.getServiceManager().getLoginService().loginAsync(login, password);
    }

    @DebugLog
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void loginReceived(LoginResponseEvent lre) {
        //Log.d(TAG, "received");
        if (null != lre.getLoginResponse()) {
            view.loginOk();
        }
    }

}
