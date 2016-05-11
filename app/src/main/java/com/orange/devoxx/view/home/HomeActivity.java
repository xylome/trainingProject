package com.orange.devoxx.view.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.orange.devoxx.R;
import com.orange.devoxx.data.DataManager;
import com.orange.devoxx.view.BaseActivity;
import com.orange.devoxx.view.login.LoginActivity;


import org.greenrobot.eventbus.Subscribe;

import butterknife.Bind;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;

public class HomeActivity extends BaseActivity<HomePresenter> implements HomeView {
    private final String TAG = "HomeActivity";

    private String mFoo;
    private String mNick;
    private Object mUserInfos;

    @Bind(R.id.home_hello) TextView mHello;
    @Bind(R.id.home_button) Button mButton;

    @Override
    protected HomePresenter newPresenter() {
        return new HomePresenter(this);
    }

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setupMembers();
        setupToolbar();
        setupFab();
       }

    @DebugLog
    private void loginIfNeeded() {
        if(!DataManager.getInstance(getApplicationContext()).getLogged()) {
           backToLogin();
        }
    }

    private void setupMembers() {
        mHello.setText("Yes, it's hello world time !");
    }

    @Override
    protected void onResume() {
        super.onResume();
        loginIfNeeded();
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupFab() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            presenter.logout();
        }
        return super.onOptionsItemSelected(item);
    }

    @DebugLog
    @Override
    public void backToLogin() {
        startActivity(LoginActivity.getIntent(this));
        finish();
        return;
    }

    @Override
    public void displayNick(String nick) {
        mHello.setText(nick);
    }


    public static Intent getIntent(Context c) {
        Intent i =  new Intent(c, HomeActivity.class);
        return i;
    }
}
