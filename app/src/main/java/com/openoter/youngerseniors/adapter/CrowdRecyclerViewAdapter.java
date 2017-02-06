package com.openoter.youngerseniors.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.openoter.youngerseniors.R;
import com.openoter.youngerseniors.entity.FriendCrowdEntity;

import java.util.List;

/**
 * 群组的数据适配器
 */

public class CrowdRecyclerViewAdapter extends RecyclerView.Adapter<CrowdRecyclerViewAdapter.ViewHolder>{

    private List<FriendCrowdEntity> data;
    private LayoutInflater inflater;

    public CrowdRecyclerViewAdapter(List<FriendCrowdEntity> data, Context context) {
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.friend_crowd_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FriendCrowdEntity crowdEntity = data.get(position);
        holder.tv_crowd_name.setText(crowdEntity.getCrowdName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_crowd_name;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_crowd_name = (TextView) itemView.findViewById(R.id.tv_crowd_name);
        }
    }
}
