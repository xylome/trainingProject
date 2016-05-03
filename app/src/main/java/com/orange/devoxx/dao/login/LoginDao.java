package com.orange.devoxx.dao.login;

import android.content.Context;
import android.util.Log;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.com.backend.beans.LoginResponse;
import com.orange.devoxx.dao.DaoManager;
import com.orange.devoxx.dao.model.LoginInfo;

import hugo.weaving.DebugLog;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by xylome on 02/05/2016.
 */
public class LoginDao implements LoginDaoIntf {

    public LoginDao(DaoManager dao) {}

    @DebugLog
    @Override
    public void saveLoginInfo(LoginResponse lr) {

            RealmConfiguration realmConfig = new RealmConfiguration.Builder(MyApplication.instance.getApplicationContext()).build();
            Realm realm = Realm.getInstance(realmConfig);
            try {
                LoginInfo li = realm.where(LoginInfo.class).equalTo("id", 4).findFirst();
                if (li == null) {
                    li = new LoginInfo();
                }
                realm.beginTransaction();
                li.setId(4);
                li.setNick(lr.getNick());
                li.setAccountId(lr.getAccountId());
                li.setEmail(lr.getEmail());
                li.setAuthCookie(lr.getAuthCookie());
                li.setActorId(lr.getActorId());
                realm.commitTransaction();
            } catch (Exception e) {
                Log.e("LoginDao", "Realm sux: " + e.getMessage());
                realm.cancelTransaction();
            }

    }
}
