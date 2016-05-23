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

    public Group setId(int mId) {
        this.mId = mId;
        return this;
    }

    public String getName() {
        return mName;
    }

    public Group setName(String mName) {
        this.mName = mName;
        return this;
    }

    public int getFraction() {
        return mFraction;
    }

    public Group setFraction(int mFraction) {
        this.mFraction = mFraction;
        return this;
    }

    public int getCreatorId() {
        return mCreatorId;
    }

    public Group setCreatorId(int mCreatorId) {
        this.mCreatorId = mCreatorId;
        return this;
    }

    public String getCreatorNick() {
        return mCreatorNick;
    }

    public Group setCreatorNick(String mCreatorNick) {
        this.mCreatorNick = mCreatorNick;
        return this;
    }
}
