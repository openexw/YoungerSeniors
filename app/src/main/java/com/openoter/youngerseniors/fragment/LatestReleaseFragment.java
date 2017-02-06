package com.openoter.youngerseniors.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.openoter.youngerseniors.R;
import com.openoter.youngerseniors.adapter.TopicLatestReleaseAdapter;
import com.openoter.youngerseniors.entity.TopicLatestReleaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 话题-最新发布
 */
public class LatestReleaseFragment extends Fragment{
    private ListView listView;
    private List<TopicLatestReleaseEntity> data;
    private TopicLatestReleaseAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topic_latest_release, container, false);
        listView = (ListView) view.findViewById(R.id.lv_latest_release);
        initData();
        adapter = new TopicLatestReleaseAdapter(data, getContext());
        listView.setAdapter(adapter);
        return view;
    }

    private void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TopicLatestReleaseEntity entity = new TopicLatestReleaseEntity();
            entity.setId(i+1);
            entity.setUserName("K-"+i);
            entity.setPublishTime("2016-10-2"+i);
            /*private int Id;
            private String UserName;
            private String MegContent;
            private String ViewTimes;
            private String CommentTime;*/
            entity.setMegContent("这是测试内容"+i);
            entity.setCommentTime(i+10+"");
            entity.setViewTimes(i+5+"");
            data.add(entity);
        }
    }
}
