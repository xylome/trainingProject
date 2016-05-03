package com.orange.devoxx.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import hugo.weaving.DebugLog;

/**
 * Created by xylome on 03/05/2016.
 */
public class DataManager {

    private final String KEY_LOGGED = "key_logged";
    private final String KEY_NICK = "key_nick";
    private final String KEY_ACCOUNT_ID = "key_account_id";
    private final String KEY_ACTOR_ID = "key_actor_id";
    private final String KEY_EMAIL = "key_email";
    private final String KEY_COOKIE = "key_cookie";

    private static DataManager mInstance;

    private SharedPreferences mSharedPrefs;

    private DataManager(Context ctx) {
        mSharedPrefs = PreferenceManager.getDefaultSharedPreferences(ctx.getApplicationContext());
    }

    public static DataManager getInstance(Context context) {
        if (null == mInstance) {
            mInstance = new DataManager(context);
        }
        return mInstance;
    }

    private void writeString(String key, String value){
        SharedPreferences.Editor e = mSharedPrefs.edit();
        e.putString(key, value);
        e.commit();
    }

    private void writeInt(String key, int value) {
        SharedPreferences.Editor e = mSharedPrefs.edit();
        e.putInt(key, value);
        e.commit();
    }

    @DebugLog
    private void writeBool(String key, boolean value) {
        SharedPreferences.Editor e = mSharedPrefs.edit();
        e.putBoolean(key, value);
        e.commit();
    }

    @DebugLog
    public void writeLogged(boolean logged) {
        writeBool(KEY_LOGGED, logged);
    }

    @DebugLog
    public boolean getLogged() {
        return mSharedPrefs.getBoolean(KEY_LOGGED, false);
    }

    public void writeNick(String nick) {
        writeString(KEY_NICK, nick);
    }

    public String getNick() {
        return mSharedPrefs.getString(KEY_NICK, null);
    }

    public void writeEmail(String email) {
        writeString(KEY_EMAIL, email);
    }

    public String getEmail() {
        return mSharedPrefs.getString(KEY_EMAIL, null);
    }

    public void writeActorId(String actor_id) {
        writeString(KEY_ACTOR_ID, actor_id);
    }

    public String getActorId() {
        return mSharedPrefs.getString(KEY_ACTOR_ID, null);
    }

    public void writeAccountId(String account_id) {
        writeString(KEY_ACCOUNT_ID, account_id);
    }

    public String getAccountId() {
        return mSharedPrefs.getString(KEY_ACCOUNT_ID, null);
    }

    public void writeCookie(String cookie) {
        writeString(KEY_COOKIE, cookie);
    }

    public String getCookie() {
        return mSharedPrefs.getString(KEY_COOKIE, null);
    }

}
