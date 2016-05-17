package com.orange.devoxx.service.login;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.com.backend.beans.LoginResponse;
import com.orange.devoxx.data.DataManager;
import com.orange.devoxx.event.LoginResponseEvent;
import com.orange.devoxx.event.LogoutResponseEvent;
import com.orange.devoxx.injector.Injector;
import com.orange.devoxx.service.MotherService;
import org.greenrobot.eventbus.EventBus;

import hugo.weaving.DebugLog;

/**
 * Created by xylome on 28/04/2016.
 */
public class LoginService extends MotherService implements LoginServiceIntf{

    private LoginResponse mLoginResponse;

    public boolean isLogged() {
        return false;
    }

    @DebugLog
    public void loginAsync(String login, String password) {
        MyApplication.instance.getServiceManager().getCancelableThreadsExecutor().submit(new LoginRunnable(login, password));
    }

    @Override
    public void logoutAsync() {
        MyApplication.instance.getServiceManager().getCancelableThreadsExecutor().submit(new LogoutRunnable());
    }

    @DebugLog
    public void loginSync(String login, String password) {
        mLoginResponse = Injector.getDataCommunication().login(login, password);
        saveLoginResponse();
        postLoginResponse();
    }

    @DebugLog
    private void saveLoginResponse() {
        DataManager dm = DataManager.getInstance(MyApplication.instance.getApplicationContext());
        dm.writeAccountId(mLoginResponse.getAccountId());
        dm.writeActorId(mLoginResponse.getActorId());
        dm.writeCookie(mLoginResponse.getAuthCookie());
        dm.writeEmail(mLoginResponse.getEmail());
        dm.writeNick(mLoginResponse.getNick());
        dm.writeLogged(true);
        dm = null;
    }

    @DebugLog
    private void logoutSync() {
        DataManager dm = DataManager.getInstance(MyApplication.instance.getApplicationContext());
        dm.writeAccountId(null);
        dm.writeActorId(null);
        dm.writeCookie(null);
        //dm.writeEmail(null);
        dm.writeNick(null);
        dm.writeLogged(false);
        dm = null;
        postLogoutResponse();
    }

    @DebugLog
    private void postLoginResponse() {
        EventBus.getDefault().post(new LoginResponseEvent(mLoginResponse));
    }

    private void postLogoutResponse() {
        EventBus.getDefault().post(new LogoutResponseEvent());
    }

    private class LoginRunnable implements Runnable {
        String mLogin;
        String mPassword;

        public LoginRunnable(String login, String password) {
            mLogin = login;
            mPassword = password;
        }

        @Override
        public void run() {
            loginSync(mLogin, mPassword);
        }
    }

    private class LogoutRunnable implements Runnable {
        public LogoutRunnable() {
        }
        @Override
        public void run() {
            logoutSync();
        }
    }

}
