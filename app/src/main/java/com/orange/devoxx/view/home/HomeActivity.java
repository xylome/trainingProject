package com.orange.devoxx.view.home;

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
import com.orange.devoxx.event.GroupResultEvent;
import com.orange.devoxx.event.LoginResponseEvent;
import com.orange.devoxx.event.NewActivityEvent;
import com.orange.devoxx.view.BaseActivity;

import org.greenrobot.eventbus.Subscribe;

import butterknife.Bind;
import butterknife.ButterKnife;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setupMembers();
        setupToolbar();
        setupFab();

       }

    public void displayLog(String foo) {
        mHello.setText(foo);
        Log.d(TAG, "setting mHello");
    }

    @Override
    public void displayNick(String nick) {
        mHello.setText("hello " + nick);
    }

    private void setupMembers() {
        mHello.setText("Yes, it's hello world time !");
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupMembers();
        setupListeners();
    }

    private void setupListeners() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login("xylome", "bar tabas");
            }
        });
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

    @Subscribe
    public void receivedMessage(NewActivityEvent activityEvent) {
        Log.d(TAG, "Received Message from bus:" + activityEvent.getContentDescription());
    }


    public void receivedGroup(LoginResponseEvent event) {
        Log.d(TAG, "Received a group:" + event.getLoginResponse().getNick());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void updateFabButton(boolean isSelected, boolean animate) {

    }
}
