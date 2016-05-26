package com.orange.devoxx.com.backend.beans;

import com.google.gson.annotations.SerializedName;
import com.orm.dsl.Table;
import com.orm.dsl.Unique;

/**
 * Created by xylome on 17/05/2016.
 */
@Table
public class GroupModel {
    @Unique
    @SerializedName("group_id")
    private long mGroupId;

    @SerializedName("group_name")
    private String mName;

    @SerializedName("group_fraction")
    private int mFraction;

    @SerializedName("creator_id")
    private int mCreatorId;

    @SerializedName("creator_nick")
    private String mCreatorNick;


    public long getGroupId() {
        return mGroupId;
    }

    public long getId() {
        return mGroupId;
    }

    public GroupModel setId(long id) {
        this.mGroupId = id;
        return this;
    }

    public String getName() {
        return mName;
    }

    public GroupModel setName(String mName) {
        this.mName = mName;
        return this;
    }

    public int getFraction() {
        return mFraction;
    }

    public GroupModel setFraction(int mFraction) {
        this.mFraction = mFraction;
        return this;
    }

    public int getCreatorId() {
        return mCreatorId;
    }

    public GroupModel setCreatorId(int mCreatorId) {
        this.mCreatorId = mCreatorId;
        return this;
    }

    public String getCreatorNick() {
        return mCreatorNick;
    }

    public GroupModel setCreatorNick(String mCreatorNick) {
        this.mCreatorNick = mCreatorNick;
        return this;
    }
}
