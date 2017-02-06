package com.openoter.youngerseniors.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.openoter.youngerseniors.R;
import com.openoter.youngerseniors.adapter.BaseFragmentPagerAdapter;

import java.util.ArrayList;

public class FriendFragment extends Fragment {
    private ViewPager pager;
    private RadioGroup radioGroup;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_friend, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        radioGroup = (RadioGroup) view.findViewById(R.id.rg_friend);
        //初始化ViewPage
        pager = (ViewPager) view.findViewById(R.id.friend_pager);
        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        titles.add("");
        titles.add("");
        titles.add("");
        fragments.add(new ChatMsgFragment());
        fragments.add(new FriendGroupFragment());
        fragments.add(new FriendCrowdFragment());
        pager.setAdapter(new BaseFragmentPagerAdapter(getChildFragmentManager(), titles, fragments));
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        radioGroup.check(R.id.rb_chat);
                        break;
                    case 1:
                        radioGroup.check(R.id.rb_friend_group);
                        break;
                    case 2:
                        radioGroup.check(R.id.rb_friend_crowd);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        pager.setCurrentItem(0);



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                switch (checkId){
                    case R.id.rb_chat:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.rb_friend_group:
                        pager.setCurrentItem(1);
                        break;
                    case R.id.rb_friend_crowd:
                        pager.setCurrentItem(2);
                        break;
                }
            }
        });
    }
}
