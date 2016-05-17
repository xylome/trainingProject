package com.orange.devoxx.com.backend.beans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xylome on 17/05/2016.
 */
public class Group {
    @SerializedName("group_id")
    private int mId;

    @SerializedName("group_name")
    private String mName;

    @SerializedName("group_fraction")
    private int mFraction;

    @SerializedName("creator_id")
    private int mCreatorId;

    @SerializedName("creator_nick")
    private String mCreatorNick;

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getFraction() {
        return mFraction;
    }

    public void setFraction(int mFraction) {
        this.mFraction = mFraction;
    }

    public int getCreatorId() {
        return mCreatorId;
    }

    public void setCreatorId(int mCreatorId) {
        this.mCreatorId = mCreatorId;
    }

    public String getCreatorNick() {
        return mCreatorNick;
    }

    public void setCreatorNick(String mCreatorNick) {
        this.mCreatorNick = mCreatorNick;
    }
}
