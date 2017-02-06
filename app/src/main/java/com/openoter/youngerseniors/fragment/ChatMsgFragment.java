package com.openoter.youngerseniors.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.openoter.youngerseniors.R;
import com.openoter.youngerseniors.adapter.ChatListViewAdapter;
import com.openoter.youngerseniors.adapter.ChatRecyclerViewAdapter;
import com.openoter.youngerseniors.entity.FriendGroupChildAndChatEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by marmo on 2016/11/6.
 */

public class ChatMsgFragment extends Fragment {
//    private ListView lv_chat_friend;
//    private ChatListViewAdapter adapter;
    private RecyclerView rv_chat_friend;
    private ChatRecyclerViewAdapter adapter;
    private List<FriendGroupChildAndChatEntity> data;
    private LinearLayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_msg, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
//        lv_chat_friend = (ListView) view.findViewById(R.id.lv_chat_friend);
        initData();
//        adapter = new ChatListViewAdapter(data, getContext());
//        lv_chat_friend.setAdapter(adapter);
        rv_chat_friend = (RecyclerView) view.findViewById(R.id.rv_chat_friend);
        rv_chat_friend.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_chat_friend.setLayoutManager(mLayoutManager);
        adapter = new ChatRecyclerViewAdapter(data, getContext());
        rv_chat_friend.setAdapter(adapter);
    }

    private void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            FriendGroupChildAndChatEntity chatEntity = new FriendGroupChildAndChatEntity();
            chatEntity.setGroupId(i + "");
            chatEntity.setLastMsg("今天天气真的很好啊，不出去玩玩？" + i);
            chatEntity.setLastSendTime(new Date().getTime());
            chatEntity.setUserName("Linda" + i);
            chatEntity.setUserId(i + "");


            data.add(chatEntity);
        }
    }
}
