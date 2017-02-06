package com.openoter.youngerseniors.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.openoter.youngerseniors.R;
import com.openoter.youngerseniors.adapter.FindFragmentAdapter;
import com.openoter.youngerseniors.entity.FindFriend;

import java.util.ArrayList;
import java.util.List;

/**
 * 发现
 */

public class FindFragment extends Fragment {
    private ListView lv_find_con;
    private FindFragmentAdapter adapter;
    private List<FindFriend> data = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        lv_find_con = (ListView) view.findViewById(R.id.lv_find_con);
        initData();
        adapter = new FindFragmentAdapter(getContext(), data);
        lv_find_con.setAdapter(adapter);

    }

    private void initData() {
        String[] major = {"自动化", "电子商务", "会计", "计算机","通信"};
        for (int i = 0; i < 20; i++) {
            FindFriend friend = new FindFriend();
            friend.setId(i+"");
            friend.setUserName("用户"+i);
            friend.setExperience(i);
            friend.setAvatar("");
            friend.setUniversity("重庆邮电大学");
            int index = i%5;
            friend.setMajor(major[index]);
            String sex = "";
            if(i > 5 && i<10 || i>10 && i<15){
                sex = "女";
            }else{
                sex = "男";
            }
            friend.setSex(sex);
            friend.setStartedSchool("201"+index);

            data.add(friend);
        }

    }
}
