package com.orange.devoxx.data;


import android.content.Context;

import com.orange.devoxx.R;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DataManagerTest {

    private static final String FAKE_STRING = "foo app name";

    @Mock
    private Context context;

    @Test
    public void testFoo() {
        Mockito.when(context.getString(R.string.app_name))
                .thenReturn(FAKE_STRING);

        String result = context.getString(R.string.app_name);
        Assert.assertThat(result, Is.is(FAKE_STRING));
    }
}