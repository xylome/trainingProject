package com.orange.devoxx.event;

/**
 * Created by xylome on 21/04/2016.
 */
public class NewActivityEvent {

    private String mContentDesc;

    public NewActivityEvent(String foo) {
        mContentDesc = foo;
    }

    public String getContentDescription() {
        return mContentDesc;
    }

}
