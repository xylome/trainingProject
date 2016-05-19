package com.orange.devoxx.com.backend.beans;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import hugo.weaving.DebugLog;

/**
 * Created by xylome on 17/05/2016.
 */
public class GroupResponse {
    @SerializedName("data")
    private ArrayList<Group> mGroups;

    public GroupResponse() {
        mGroups = new ArrayList<>();
    }

    public int count() {
        return mGroups.size();
    }

    public void addGroup(Group g) {
        if (null != g) {
            mGroups.add(g);
        }
    }

    public ArrayList<Group> getGroups() {
        return mGroups;
    }
}
