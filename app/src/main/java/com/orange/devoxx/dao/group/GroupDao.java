package com.orange.devoxx.dao.group;

import android.util.Log;

import com.orange.devoxx.MyApplication;
import com.orange.devoxx.com.backend.beans.Group;
import com.orange.devoxx.dao.DaoManager;
import com.orange.devoxx.dao.model.GroupModel;

import java.util.ArrayList;

import hugo.weaving.DebugLog;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by xylome on 23/05/2016.
 */
public class GroupDao implements GroupDaoIntf {

    private static final String TAG = "GroupDao" ;
    private RealmConfiguration mRealmConf;


    public GroupDao(DaoManager daoManager) {
        if (mRealmConf == null) {
            mRealmConf = new RealmConfiguration.Builder(MyApplication.instance.getApplicationContext())
                    .deleteRealmIfMigrationNeeded()
                    .build();
        }
    }

    private Realm getRealmInstance() {
        Realm realm = null;
        try {
             realm = Realm.getInstance(mRealmConf);
        } catch (Exception e) {
            Log.e(TAG, "<init> Realm said: " + e.getMessage());
        }
        return realm;
    }

    @DebugLog
    @Override
    public void saveGroup(Group group) {
        GroupModel gm = groupToGroupModel(group);

        Realm realm = getRealmInstance();
        if (realm == null) {
            Log.e(TAG, "Realm was null");
            return;
        }
        try {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(gm);
            realm.commitTransaction();
        } catch (Exception e) {
            Log.e(TAG, "Realm said: " + e.getMessage());
        }
    }

    @Override
    public void saveGroups(ArrayList<Group> groups) {
        for(Group current: groups) {
            saveGroup(current);
        }

    }

    @DebugLog
    @Override
    public ArrayList<Group> getGroups() {
        ArrayList<Group> result = new ArrayList<>();
        Realm realm = getRealmInstance();

        if (realm == null) {
            Log.e(TAG, "Realm was null");
            return null;
        }
        final RealmResults<GroupModel> realmResults = realm.where(GroupModel.class).findAll();

        for(GroupModel current : realmResults) {
            result.add(groupModelToGroup(current));
        }
        return result;
    }

    private GroupModel groupToGroupModel(Group group) {
        GroupModel gm = new GroupModel()
                .setId(group.getId())
                .setCreatorId(group.getCreatorId())
                .setName(group.getName())
                .setCreatorNick(group.getCreatorNick())
                .setCreatorId(group.getCreatorId())
                .setFraction(group.getFraction())
                ;
        return gm;
    }

    private Group groupModelToGroup(GroupModel gm) {
        Group group = new Group()
                .setId(gm.getId())
                .setCreatorId(gm.getCreatorId())
                .setName(gm.getName())
                .setCreatorNick(gm.getCreatorNick())
                .setCreatorId(gm.getCreatorId())
                .setFraction(gm.getFraction())
                ;
        return group;
    }


}
