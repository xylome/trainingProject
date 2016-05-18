package com.orange.devoxx.com.backend.beans;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by xylome on 17/05/2016.
 */
public class GroupResponse {
    @SerializedName("data")
    private ArrayList<Group> mGroups;

    public int count() {
        return mGroups.size();
    }

    public ArrayList<Group> getGroups() {
        return mGroups;
    }
}
