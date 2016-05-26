package com.orange.devoxx.espresso;

import android.support.test.espresso.Espresso;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.typeText;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.orange.devoxx.R;
import com.orange.devoxx.view.home.HomeActivity;
import com.orange.devoxx.view.login.LoginActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by xylome on 26/05/2016.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginTest {

    private String login;
    private String password;

    @Rule
    public ActivityTestRule<HomeActivity> mActivityTestRule = new ActivityTestRule<>(HomeActivity.class);

    @Before
    public void initStrings() {
        login = "xavier@chacunsapart.com";
        password = "64516451";
    }

    @Test
    public void testEmailAndPassword() {
        onView(withId(R.id.email_login_form))
                .perform(typeText(login), closeSoftKeyboard());
    }

}
