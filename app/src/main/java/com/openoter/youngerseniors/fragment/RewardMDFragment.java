package com.openoter.youngerseniors.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.openoter.youngerseniors.R;
import com.openoter.youngerseniors.adapter.TopicRewardAdapter;
import com.openoter.youngerseniors.entity.TopicLatestReleaseEntity;
import com.openoter.youngerseniors.entity.TopicRewardEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2016/10/23.
 */

public class RewardMDFragment extends Fragment {
    private ListView lv_reward;
    private List<TopicRewardEntity> data;
    private TopicRewardAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topic_reward_mai_dou, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        lv_reward = (ListView) view.findViewById(R.id.lv_reward);
        initData();
        adapter = new TopicRewardAdapter(data, getContext());
        lv_reward.setAdapter(adapter);
    }

    private void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TopicRewardEntity entity = new TopicRewardEntity();
            entity.setId(i+1+"");
            entity.setUserName("K-"+i);
            entity.setPublishTime(i+"小时前");
            /*private int Id;
            private String UserName;
            private String MegContent;
            private String ViewTimes;
            private String CommentTime;*/
            entity.setMsgContent("这是测试内容"+i);
            entity.setCommentTimes(i+10+"");
            entity.setViewTimes(i+5+"");
            if(i%3 == 0){
                entity.setIsMine(1);
            }else{
                entity.setIsMine(0);
            }
            entity.setHelpFriendCount(10+"");
            entity.setMaiDouNum(3+i+"");
            data.add(entity);
        }
    }
}
