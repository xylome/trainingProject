package com.orange.devoxx.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.orange.devoxx.MyApplication;

import org.greenrobot.eventbus.EventBus;

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
        EventBus.getDefault().register(this);
        MyApplication.instance.activityStarted();
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        MyApplication.instance.activityStopped();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Log.d("BaseActivity", "On backpressed");
        super.onBackPressed();
    }
}
