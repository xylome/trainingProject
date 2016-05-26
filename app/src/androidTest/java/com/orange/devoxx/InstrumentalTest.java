package com.orange.devoxx;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.test.suitebuilder.annotation.MediumTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.runner.AndroidJUnit4;

import com.orange.devoxx.com.backend.beans.GroupModel;
import com.orange.devoxx.view.login.LoginActivity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class InstrumentalTest {
    private static final String PARAM_ONE = "Param_one";

    private GroupModel group;
    private Context context;

    @Before
    public void createLogHistory() {
        group = new GroupModel();
        group.setName("Instrumental Group");
        context = InstrumentationRegistry.getTargetContext();

    }

    @Test
    public void testOne() {
        assertThat(group.getName(), is("Instrumental Group"));
    }

    @Test
    public void testTwo() {
        Intent i = LoginActivity.getIntent(context, PARAM_ONE);
        assertThat(i, notNullValue());
        Bundle extras = i.getExtras();
        assertThat(extras, notNullValue());
        String foo = extras.getString("FOO");
        assertThat(foo, notNullValue());
        assertThat(foo, is(PARAM_ONE));
    }

    @Test
    public void testThree() {
        Intent i = LoginActivity.getIntent(context);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

    @After
    public void afterTests() {
        group = null;
        context = null;
    }
}
