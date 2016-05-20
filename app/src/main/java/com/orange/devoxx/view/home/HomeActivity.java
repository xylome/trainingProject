package com.orange.devoxx.view.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.orange.devoxx.R;
import com.orange.devoxx.com.backend.beans.Group;
import com.orange.devoxx.com.backend.beans.GroupResponse;
import com.orange.devoxx.data.DataManager;
import com.orange.devoxx.view.BaseActivity;
import com.orange.devoxx.view.login.LoginActivity;


import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;

public class HomeActivity extends BaseActivity<HomePresenter> implements HomeView {
    private final String TAG = "HomeActivity";

    private String mFoo;
    private String mNick;
    private Object mUserInfos;
    private RecyclerView.Adapter mGroupsRecyclerAdapter;
    private RecyclerView.LayoutManager mGroupsRecyclerLayoutManager;
    private ArrayList<Group> mGroups;
    Handler mainThread = new Handler(Looper.getMainLooper());


    @Bind(R.id.home_recycler) RecyclerView mGroupsRecycler;


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
        } else {
            fillInfos();
        }
    }

    @DebugLog
    private void fillInfos() {
        presenter.myGroups();

    }

    private void setUpRecyclerAdapter() {
        if (mGroups != null) {
            mGroupsRecyclerAdapter = new HomeAdapter(mGroups);
            mGroupsRecycler.setAdapter(mGroupsRecyclerAdapter);
        }
    }

    private void setupMembers() {
        mGroupsRecycler.setHasFixedSize(false);
        mGroupsRecyclerLayoutManager = new LinearLayoutManager(getApplicationContext());
        mGroupsRecycler.setLayoutManager(mGroupsRecyclerLayoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loginIfNeeded();
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.my_groups);
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
    public void groupsUpated(GroupResponse gr) {
        Log.d(TAG, "Received " + gr.count() + " groups");
        if (gr != null && gr.count() > 0) {
            mGroups = gr.getGroups();
            /**
            mainThread.post(new Runnable() {
                @Override
                public void run() {
                    setUpRecyclerAdapter();
                }
            });
             */
            setUpRecyclerAdapter();

        } else {
            Log.e(TAG, "GR is null or count is equals to 0");
        }
    }


    public static Intent getIntent(Context c) {
        Intent i =  new Intent(c, HomeActivity.class);
        return i;
    }
}
