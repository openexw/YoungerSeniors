package com.openoter.youngerseniors.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.openoter.youngerseniors.R;
import com.openoter.youngerseniors.entity.TopicRewardEntity;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 脉豆悬赏的Adapter
 */

public class TopicRewardAdapter extends BaseAdapter {
    private List<TopicRewardEntity> data;
    private LayoutInflater inflater;
    private int TYPE_MINE=1; //我的消息
    private int TYPE_OTHER=0; //其他人的消息

    public TopicRewardAdapter(List<TopicRewardEntity> data, Context context) {
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        TopicRewardEntity reward = data.get(position);
        if(reward.getIsMine() == 1){ //我的消息
            return TYPE_MINE;
        }else{
            return TYPE_OTHER;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        ViewHolder1 holder1 = null;

        int type = getItemViewType(position);
        if(convertView == null){

            if(type == 1){ //自己的
                holder1 = new ViewHolder1();
                convertView = inflater.inflate(R.layout.reward_item, null);
                holder1.circleImageView = (CircleImageView) convertView.findViewById(R.id.circleImageView);
                holder1.tv_username = (TextView) convertView.findViewById(R.id.tv_username);
                holder1.tv_publish_time = (TextView) convertView.findViewById(R.id.tv_publish_time);
                holder1.tv_mgs_con = (TextView) convertView.findViewById(R.id.tv_mgs_con);
                holder1.gv_image = (GridView) convertView.findViewById(R.id.gv_image);
                holder1.tv_friend_help_num = (TextView) convertView.findViewById(R.id.tv_friend_help_num);
                holder1.tv_maidou_num = (TextView) convertView.findViewById(R.id.tv_maidou_num);
                convertView.setTag(holder1);
            }else{ //别人的
                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.latest_release_item, null);
                holder.circleImageView = (CircleImageView) convertView.findViewById(R.id.circleImageView);
                holder.tv_username = (TextView) convertView.findViewById(R.id.tv_username);
                holder.tv_publish_time = (TextView) convertView.findViewById(R.id.tv_publish_time);
                holder.tv_mgs_con = (TextView) convertView.findViewById(R.id.tv_mgs_con);
                holder.gv_image = (GridView) convertView.findViewById(R.id.gv_image);
                holder.ll_reward_maidou = (LinearLayout) convertView.findViewById(R.id.ll_reward_maidou);
                holder.ll_reward_maidou.setVisibility(View.VISIBLE);

                holder.tv_view_time = (TextView) convertView.findViewById(R.id.tv_view_time);
                holder.tv_maidou_num = (TextView) convertView.findViewById(R.id.tv_maidou_num);
                holder.tv_comment_times = (TextView) convertView.findViewById(R.id.tv_comment_times);
                convertView.setTag(holder);
            }

        }else{
            if(type == 1){
                holder1 = (ViewHolder1) convertView.getTag();
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
        }


        //绑定数据

        TopicRewardEntity rewardEntity = data.get(position);

        if(type == 1){ //我的消息
            holder1.tv_maidou_num.setText(rewardEntity.getMaiDouNum());
            holder1.tv_friend_help_num.setText(rewardEntity.getHelpFriendCount());
            holder1.tv_username.setText(rewardEntity.getUserName());
            holder1.tv_mgs_con.setText(rewardEntity.getMsgContent());
            holder1.tv_publish_time.setText(rewardEntity.getPublishTime());
        }else{
            holder.tv_username.setText(rewardEntity.getUserName());
            holder.tv_mgs_con.setText(rewardEntity.getMsgContent());
            holder.tv_publish_time.setText(rewardEntity.getPublishTime());
            holder.tv_view_time.setText("浏览("+rewardEntity.getViewTimes()+")");
            holder.tv_comment_times.setText(rewardEntity.getCommentTimes());
            holder.tv_maidou_num.setText(rewardEntity.getMaiDouNum());
        }
        return convertView;
    }

    /**
     * 其他人的
     */
    class ViewHolder{
        LinearLayout ll_reward_maidou;
        CircleImageView circleImageView;
        TextView tv_mgs_con,
                tv_publish_time,
                tv_username,
                tv_view_time,
                tv_maidou_num,
                tv_comment_times;
        GridView gv_image;
    }

    /**
     * 自己的
     */
    class ViewHolder1{
        CircleImageView circleImageView;
        TextView tv_friend_help_num,
                tv_mgs_con,
                tv_publish_time,
                tv_maidou_num,
                tv_username;
        GridView gv_image;
    }
}
