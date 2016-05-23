package com.orange.devoxx.dao.group;

import com.orange.devoxx.com.backend.beans.Group;

import java.util.ArrayList;

/**
 * Created by xylome on 23/05/2016.
 */
public interface GroupDaoIntf {
    public void saveGroup(Group group);
    public void saveGroups(ArrayList<Group> groups);
    public ArrayList<Group> getGroups();
}
