package com.openoter.youngerseniors.adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.openoter.youngerseniors.R;
import com.openoter.youngerseniors.entity.FriendGroupChildAndChatEntity;
import com.openoter.youngerseniors.util.TimeUtils;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by marmo on 2016/11/9.
 */

public class ChatRecyclerViewAdapter extends RecyclerView.Adapter<ChatRecyclerViewAdapter.ViewHolder> {
    private List<FriendGroupChildAndChatEntity> list;
    private LayoutInflater inflater;

    public ChatRecyclerViewAdapter(List<FriendGroupChildAndChatEntity> list, Context context) {
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fragment_friend_chat_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FriendGroupChildAndChatEntity chatEntity = list.get(position);
        holder.tv_child_user.setText(chatEntity.getUserName());
        holder.tv_child_msg.setText(chatEntity.getLastMsg());
        long lastSendTime = chatEntity.getLastSendTime();
        String strTime = TimeUtils.getStrTimeByMillis(lastSendTime, "HH:mm");
        holder.tv_last_time.setText(strTime);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView circleImageView;
        TextView tv_child_user;
        TextView tv_child_msg;
        TextView tv_last_time;

        public ViewHolder(View itemView) {
            super(itemView);
            circleImageView = (CircleImageView) itemView.findViewById(R.id.circleImageView);
            tv_child_user = (TextView) itemView.findViewById(R.id.tv_child_user);
            tv_child_user = (TextView) itemView.findViewById(R.id.tv_child_user);
            tv_child_msg = (TextView) itemView.findViewById(R.id.tv_child_msg);
            tv_last_time = (TextView) itemView.findViewById(R.id.tv_last_time);
        }
    }
}
