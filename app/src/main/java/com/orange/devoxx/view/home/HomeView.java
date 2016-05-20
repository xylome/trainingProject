package com.orange.devoxx.view.home;

import com.orange.devoxx.com.backend.beans.GroupResponse;

/**
 * Created by xylome on 25/04/2016.
 */
public interface HomeView {
    void backToLogin();
    void groupsUpated(GroupResponse gr);
}
