package com.openoter.youngerseniors.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.openoter.youngerseniors.R;
import com.openoter.youngerseniors.entity.FriendGroupChildAndChatEntity;
import com.openoter.youngerseniors.util.TimeUtils;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/***
 * 辈友-会话的adapter
 */

public class ChatListViewAdapter extends BaseAdapter {
    private List<FriendGroupChildAndChatEntity> list;
    private LayoutInflater inflater;



    public ChatListViewAdapter(List<FriendGroupChildAndChatEntity> list, Context context) {
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView != null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.fragment_friend_chat_item, null);
            holder.circleImageView = (CircleImageView) convertView.findViewById(R.id.circleImageView);
            holder.tv_child_user = (TextView) convertView.findViewById(R.id.tv_child_user);
            holder.tv_child_msg = (TextView) convertView.findViewById(R.id.tv_child_msg);
            holder.tv_last_time = (TextView) convertView.findViewById(R.id.tv_last_time);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        FriendGroupChildAndChatEntity chatEntity = list.get(position);
        holder.tv_child_user.setText(chatEntity.getUserName());
        holder.tv_child_msg.setText(chatEntity.getLastMsg());

        long lastSendTime = chatEntity.getLastSendTime();
        String strTime = TimeUtils.getStrTimeByMillis(lastSendTime, "HH:mm");
        holder.tv_last_time.setText(strTime);
        return convertView;
    }

    class ViewHolder{
        CircleImageView circleImageView;
        TextView tv_child_user;
        TextView tv_child_msg;
        TextView tv_last_time;
    }
}
