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
import com.openoter.youngerseniors.entity.TopicLatestReleaseEntity;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 最新发布的数据适配器
 */

public class TopicLatestReleaseAdapter extends BaseAdapter{
    private List<TopicLatestReleaseEntity> data;
    private LayoutInflater inflater;

    public TopicLatestReleaseAdapter(List<TopicLatestReleaseEntity> list, Context context) {
        this.data = list;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.latest_release_item, null);
            viewHolder.circleImageView = (CircleImageView) convertView.findViewById(R.id.circleImageView);
            viewHolder.tv_username = (TextView) convertView.findViewById(R.id.tv_username);
            viewHolder.tv_publish_time = (TextView) convertView.findViewById(R.id.tv_publish_time);
            viewHolder.tv_mgs_con = (TextView) convertView.findViewById(R.id.tv_mgs_con);
            viewHolder.tv_view_time = (TextView) convertView.findViewById(R.id.tv_view_time);
            viewHolder.tv_comment_times = (TextView) convertView.findViewById(R.id.tv_comment_times);

            viewHolder.ll_comment = (LinearLayout) convertView.findViewById(R.id.ll_comment);
            viewHolder.ll_answer_question = (LinearLayout) convertView.findViewById(R.id.ll_answer_question);

            viewHolder.gv_image = (GridView) convertView.findViewById(R.id.gv_image);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //绑定数据
        TopicLatestReleaseEntity releaseEntity = data.get(position);
        viewHolder.tv_username.setText(releaseEntity.getUserName());
        viewHolder.tv_publish_time.setText(releaseEntity.getPublishTime());
        viewHolder.tv_mgs_con.setText(releaseEntity.getMegContent());
        viewHolder.tv_view_time.setText("浏览("+releaseEntity.getViewTimes()+")");
        viewHolder.tv_comment_times.setText(releaseEntity.getCommentTime());
        return convertView;
    }

    class ViewHolder{
        public CircleImageView circleImageView;
        TextView tv_username,tv_publish_time,tv_mgs_con,tv_view_time, tv_comment_times;
        public LinearLayout ll_comment,ll_answer_question;
        GridView gv_image;
    }
}
