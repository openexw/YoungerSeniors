package com.openoter.youngerseniors.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.openoter.youngerseniors.R;
import com.openoter.youngerseniors.entity.FriendGroupChildAndChatEntity;
import com.openoter.youngerseniors.entity.FriendGroupEntity;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by marmo on 2016/11/6.
 */

public class FriendGroupExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Context context = null;
    private List<FriendGroupEntity> groupData = null;
    private List<FriendGroupChildAndChatEntity> childData = null;

    public FriendGroupExpandableListViewAdapter(Context context, List<FriendGroupEntity> groupData, List<FriendGroupChildAndChatEntity> childData) {
        this.context = context;
        this.groupData = groupData;
        this.childData = childData;
    }

    @Override
    public int getGroupCount() {
        return groupData.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return childData.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupData.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childData.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * position与id一样，都是从0开始计数的，
     * 这里返回的id也是从0开始计数的
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition; //??????????
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ParentViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.friend_group_layout, null);
            holder = new ParentViewHolder();
            holder.tv_group = (TextView) convertView.findViewById(R.id.tv_group);
            holder.tv_online_num = (TextView) convertView.findViewById(R.id.tv_online_num);
            holder.tv_group_friend_total = (TextView) convertView.findViewById(R.id.tv_group_friend_total);
            convertView.setTag(holder);
        } else {
            holder = (ParentViewHolder) convertView.getTag();
        }
        FriendGroupEntity groupEntity = groupData.get(groupPosition);
        holder.tv_group.setText(groupEntity.getGroupName());
        holder.tv_online_num.setText(groupEntity.getFriendOnline() + "");
        holder.tv_group_friend_total.setText(groupEntity.getFriendTotal() + "");
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.friend_child_layout, null);
            holder = new ChildViewHolder();
            holder.headImage = (CircleImageView) convertView.findViewById(R.id.circleImageView);
            holder.tv_child_user = (TextView) convertView.findViewById(R.id.tv_child_user);
            holder.tv_child_msg = (TextView) convertView.findViewById(R.id.tv_child_msg);
            convertView.setTag(holder);
        } else {
            holder = (ChildViewHolder) convertView.getTag();
        }

        FriendGroupChildAndChatEntity childEntity = childData.get(childPosition);
        holder.tv_child_user.setText(childEntity.getUserName());
        holder.tv_child_msg.setText(childEntity.getLastMsg());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    /**
     * ChildViewHolder内部类
     **/
    class ChildViewHolder {
        CircleImageView headImage;
        TextView tv_child_user;
        TextView tv_child_msg;
    }

    class ParentViewHolder {
        TextView tv_group;
        TextView tv_online_num;
        TextView tv_group_friend_total;

    }

    /**
     * 头像点击事件监听类
     **/
    class ImageClickListener implements View.OnClickListener {

        ChildViewHolder holder = null;

        public ImageClickListener(ChildViewHolder holder) {
            this.holder = holder;
        }

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Toast.makeText(context, holder.tv_child_user.getText() + " is clicked", Toast.LENGTH_SHORT).show();

        }

    }
}
