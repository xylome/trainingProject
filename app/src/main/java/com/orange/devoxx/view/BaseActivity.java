package com.orange.devoxx.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.orange.devoxx.MyApplication;

import org.greenrobot.eventbus.EventBus;

import hugo.weaving.DebugLog;

/**
 * Created by xylome on 25/04/2016.
 */
public abstract class BaseActivity<P extends BaseActivityPresenter> extends AppCompatActivity {
    protected P presenter;

    protected abstract P newPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = newPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        MyApplication.instance.activityStarted();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.subscrible();
    }

    @DebugLog
    @Override
    protected void onPause() {
        presenter.unsubscribe();
        super.onPause();

    }

    @DebugLog
    @Override
    protected void onStop() {
        MyApplication.instance.activityStopped();
        super.onStop();
    }

    @DebugLog
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
