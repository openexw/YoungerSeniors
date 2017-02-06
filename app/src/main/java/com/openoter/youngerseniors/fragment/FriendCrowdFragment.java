package com.openoter.youngerseniors.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openoter.youngerseniors.R;
import com.openoter.youngerseniors.adapter.CrowdRecyclerViewAdapter;
import com.openoter.youngerseniors.entity.FriendCrowdEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marmo on 2016/11/6.
 */

public class FriendCrowdFragment extends Fragment {
    private List<FriendCrowdEntity> data_create,data_join;
    private RecyclerView rv_crowd, rv_crowd_join;
    private CrowdRecyclerViewAdapter adapter_create, adapter_join;
    private LinearLayoutManager mLayoutManager, mLayoutManagerJoin;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_crowd, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        rv_crowd = (RecyclerView) view.findViewById(R.id.rv_crowd);
        rv_crowd_join = (RecyclerView) view.findViewById(R.id.rv_crowd_join);
        initData();
        rv_crowd.setHasFixedSize(true);
        rv_crowd_join.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_crowd.setLayoutManager(mLayoutManager);

        mLayoutManagerJoin = new LinearLayoutManager(getContext());
        mLayoutManagerJoin.setOrientation(LinearLayoutManager.VERTICAL);
        rv_crowd_join.setLayoutManager(mLayoutManagerJoin);
        adapter_create = new CrowdRecyclerViewAdapter(data_create, getContext());
        adapter_join = new CrowdRecyclerViewAdapter(data_join, getContext());


        rv_crowd.setAdapter(adapter_create);
        rv_crowd_join.setAdapter(adapter_join);

    }

    private void initData() {
        data_create = new ArrayList<>();
        data_join = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            FriendCrowdEntity crowdEntity = new FriendCrowdEntity();
            crowdEntity.setCrowdId(i+"");
            crowdEntity.setCrowdName("我创建的群"+i);
            data_create.add(crowdEntity);
        }

        for (int i = 0; i < 5; i++) {
            FriendCrowdEntity crowdJoin = new FriendCrowdEntity();
            crowdJoin.setCrowdId("00"+i);
            crowdJoin.setCrowdId("我加入的群"+i);
            data_join.add(crowdJoin);
        }
    }
}
