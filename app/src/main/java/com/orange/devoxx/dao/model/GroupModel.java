package com.orange.devoxx.dao.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


/**
 * Created by xylome on 17/05/2016.
 */
public class GroupModel extends RealmObject {
    @PrimaryKey

    private int mId;


    private String mName;


    private int mFraction;


    private int mCreatorId;


    private String mCreatorNick;

    public int getId() {
        return mId;
    }

    public GroupModel setId(int mId) {
        this.mId = mId;
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
