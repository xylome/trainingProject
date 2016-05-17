package com.orange.devoxx.com.backend.beans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xylome on 17/05/2016.
 */
public class MyGroupsQuery {
    @SerializedName("acct_id")
    private int mAccountId;

    public MyGroupsQuery(int accountId) {
        mAccountId = accountId;
    }

}
