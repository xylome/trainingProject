package com.orange.devoxx.view.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orange.devoxx.R;
import com.orange.devoxx.com.backend.beans.Group;

import java.util.ArrayList;

/**
 * Created by xylome on 18/05/2016.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private ArrayList<Group> mData;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mGroupName;

        public ViewHolder(View itemView) {
            super(itemView);
            mGroupName = (TextView) itemView.findViewById(R.id.home_group_name);
        }
    }


    public HomeAdapter(ArrayList<Group> groups) {
        mData = groups;
    }

    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_home_group, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder vh, int position) {
        vh.mGroupName.setText(mData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
