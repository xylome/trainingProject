package com.orange.devoxx.dao.group;

import android.util.Log;

import com.orange.devoxx.com.backend.beans.GroupModel;
import com.orange.devoxx.dao.DaoManager;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import hugo.weaving.DebugLog;

/**
 * Created by xylome on 23/05/2016.
 */
public class GroupDao implements GroupDaoIntf {
    private static final String TAG = "GroupDao " ;

    public GroupDao(DaoManager daoManager) {
    }

    @DebugLog
    @Override
    public void saveGroup(GroupModel group) {
        SugarRecord.save(group);
    }

    @Override
    public void saveGroups(ArrayList<GroupModel> groups) {
        for(GroupModel current: groups) {
            saveGroup(current);
        }
    }

    @DebugLog
    @Override
    public ArrayList<GroupModel> getGroups() {
        ArrayList<GroupModel> result = new ArrayList<>();

        try {
            List<GroupModel> resultList = SugarRecord.listAll(GroupModel.class);
            result.addAll(resultList);
        } catch (Exception e) {
            Log.e(TAG, "ORM problem: " + e.getMessage());
        }

        return result;
    }

    public GroupModel findGroupById(int id) {
        List<GroupModel> resultList = SugarRecord.find(GroupModel.class, "M_GROUP_ID = ?", id + "");
        return resultList.get(0);
    }

    public void deleteAll() {
        SugarRecord.deleteAll(GroupModel.class);
    }
}
