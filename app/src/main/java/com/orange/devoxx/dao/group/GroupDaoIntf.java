package com.orange.devoxx.dao.group;

import com.orange.devoxx.com.backend.beans.GroupModel;

import java.util.ArrayList;

/**
 * Created by xylome on 23/05/2016.
 */
public interface GroupDaoIntf {
    public void saveGroup(GroupModel group);
    public void saveGroups(ArrayList<GroupModel> groups);
    public ArrayList<GroupModel> getGroups();
    public GroupModel findGroupById(int id);
    public void deleteAll();
}
