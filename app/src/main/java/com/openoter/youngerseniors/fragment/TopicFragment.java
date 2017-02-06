package com.openoter.youngerseniors.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import com.gxz.PagerSlidingTabStrip;
import com.openoter.youngerseniors.R;
import com.openoter.youngerseniors.activity.AdvanceSearchActivity;
import com.openoter.youngerseniors.adapter.BaseFragmentPagerAdapter;
import com.openoter.youngerseniors.weight.ONToolbar;

import java.util.ArrayList;
import java.util.List;

/**
 * 话题
 */

public class TopicFragment extends Fragment {
    /* private ViewPager mViewPager;
     private RadioGroup radioGroup;
     private RadioButton rb_new_item,rb_maidou,rb_about_me;*/
    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private ONToolbar mToolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topic, container, false);

        initViews(view);
        ArrayList<String> titles = new ArrayList<>();
        titles.add("最新发布");
        titles.add("脉豆悬赏");
        titles.add("与我相关");

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new LatestReleaseFragment());
        fragments.add(new RewardMDFragment());
        fragments.add(new AboutMeFragment());
        pager.setAdapter(new BaseFragmentPagerAdapter(getChildFragmentManager(), titles, fragments));
        tabs.setViewPager(pager);
        pager.setCurrentItem(0);
        return view;
    }

    private void initViews(View view) {
        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        pager = (ViewPager) view.findViewById(R.id.pager);
        mToolbar = (ONToolbar) view.findViewById(R.id.toolbar);
        initEvent();

    }

    private void initEvent() {
        mToolbar.setRightButtonOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AdvanceSearchActivity.class);
                startActivity(intent);
            }
        });
    }

}
