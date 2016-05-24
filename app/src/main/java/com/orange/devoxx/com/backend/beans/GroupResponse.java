package com.orange.devoxx.com.backend.beans;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by xylome on 17/05/2016.
 */
public class GroupResponse {
    @SerializedName("data")
    private ArrayList<GroupModel> mGroups;

    public GroupResponse() {
        mGroups = new ArrayList<>();
    }

    public int count() {
        return mGroups.size();
    }

    public void addGroup(GroupModel g) {
        if (null != g) {
            mGroups.add(g);
        }
    }

    public void setGroups(ArrayList<GroupModel> groups) {
        mGroups = groups;
    }

    public ArrayList<GroupModel> getGroups() {
        return mGroups;
    }
}
