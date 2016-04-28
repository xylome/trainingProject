package com.orange.devoxx.event;

/**
 * Created by xylome on 22/04/2016.
 */
public class GroupResultEvent {

    private String mGroup;

    public GroupResultEvent(String group) {
        mGroup = group;
    }

    public String getGroup() {
        return mGroup;
    }
}
