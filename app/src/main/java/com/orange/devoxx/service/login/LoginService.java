package com.orange.devoxx.service.login;

import android.util.Log;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.event.LoginResponseEvent;
import com.orange.devoxx.injector.Injector;
import com.orange.devoxx.service.MotherService;
import com.orange.devoxx.transverse.model.LoginResponse;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by xylome on 28/04/2016.
 */
public class LoginService extends MotherService implements LoginServiceIntf{

    private LoginResponse mLoginResponse;

    public boolean isLogged() {
        return false;
    }


    public void loginAsync(String login, String password) {
        MyApplication.instance.getServiceManager().getCancelableThreadsExecutor().submit(new DownloadRunnable(login, password));
    }

    public void loginSync(String login, String password) {
        mLoginResponse = Injector.getDataCommunication().login(login, password);

        // il faut poster la réponse.
        postLoginResponse();
    }

    private void postLoginResponse() {
        EventBus.getDefault().post(new LoginResponseEvent(mLoginResponse));
    }

    private class DownloadRunnable implements Runnable {
        String mLogin;
        String mPassword;

        public DownloadRunnable(String login, String password) {
            mLogin = login;
            mPassword = password;
        }

        @Override
        public void run() {
            loginSync(mLogin, mPassword);
        }
    }



}
