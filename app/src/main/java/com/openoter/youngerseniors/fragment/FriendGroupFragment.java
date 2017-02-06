package com.openoter.youngerseniors.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.openoter.youngerseniors.R;
import com.openoter.youngerseniors.adapter.FriendGroupExpandableListViewAdapter;
import com.openoter.youngerseniors.entity.FriendGroupChildAndChatEntity;
import com.openoter.youngerseniors.entity.FriendGroupEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marmo on 2016/11/6.
 */

public class FriendGroupFragment extends Fragment {
    private List<FriendGroupEntity> groupData = new ArrayList<>();
    private List<FriendGroupChildAndChatEntity> childData = new ArrayList<>();
    private ExpandableListView expandableListView;
    private FriendGroupExpandableListViewAdapter expandableListViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_group, container, false);

        expandableListView = (ExpandableListView) view.findViewById(android.R.id.list);

        initData();
        expandableListViewAdapter = new FriendGroupExpandableListViewAdapter(getContext(), groupData, childData);

        expandableListView.setAdapter(expandableListViewAdapter);


        return view;
    }

    private void initData() {
        for (int i = 0; i < 2; i++) {
            FriendGroupEntity groupEntity = new FriendGroupEntity();
            groupEntity.setFriendOnline(2 + i);
            groupEntity.setGroupId(i + "");
            groupEntity.setFriendTotal(20);
            groupEntity.setGroupName("分组" + i);

            groupData.add(groupEntity);
        }

        for (int i = 0; i < 6; i++) {
            FriendGroupChildAndChatEntity childEntity = new FriendGroupChildAndChatEntity();
            childEntity.setUserId(i + "");
            childEntity.setGroupId(i + "");
            childEntity.setUserName("User-" + i);
            childEntity.setLastMsg("这是最后一条数据测试" + i);
            childData.add(childEntity);
        }
    }


}
