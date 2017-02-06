package com.openoter.youngerseniors.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.openoter.youngerseniors.R;
import com.openoter.youngerseniors.entity.FindFriend;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by asus on 2016/10/28.
 */

public class FindFragmentAdapter extends BaseAdapter {

    private List<FindFriend> data;
    private LayoutInflater inflater;

    public FindFragmentAdapter(Context context, List<FindFriend> data) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.find_item, null);
            holder.circleImageView = (CircleImageView) convertView.findViewById(R.id.circleImageView);
            holder.find_tv_username = (TextView) convertView.findViewById(R.id.find_tv_username);
            holder.find_tv_experience_num = (TextView) convertView.findViewById(R.id.find_tv_experience_num);
            holder.find_tv_year_in = (TextView) convertView.findViewById(R.id.find_tv_year_in);
            holder.find_tv_major = (TextView) convertView.findViewById(R.id.find_tv_major);

            holder.find_iv_sex = (ImageView) convertView.findViewById(R.id.find_iv_sex);

            convertView.setTag(holder);
        }else{
             holder = (ViewHolder) convertView.getTag();
        }

        //绑定数据
        FindFriend findFriend = data.get(position);
        holder.find_tv_username.setText(findFriend.getUserName());
        holder.find_tv_experience_num.setText(findFriend.getExperience()+"");
        holder.find_tv_year_in.setText(findFriend.getStartedSchool()+"年入学");
        holder.find_tv_major.setText(findFriend.getUniversity()+" "+findFriend.getMajor());

        String sex = findFriend.getSex();
        if(sex.equals("男")){
             holder.find_iv_sex.setBackgroundResource(R.drawable.man);
        }else{
             holder.find_iv_sex.setBackgroundResource(R.drawable.woman);
        }
        return convertView;
    }

    class ViewHolder{
        CircleImageView circleImageView;
        TextView find_tv_username,find_tv_year_in,find_tv_experience_num,find_tv_major;
        ImageView find_iv_sex;
    }
}
