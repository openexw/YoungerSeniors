package com.openoter.youngerseniors.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.openoter.youngerseniors.R;
import com.openoter.youngerseniors.adapter.BaseFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 话题
 */

public class TopicFragmentBak extends Fragment{
    private ViewPager mViewPager;
    private RadioGroup radioGroup;
    private RadioButton rb_new_item,rb_maidou,rb_about_me;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topic, container, false);
        initView(view);
        initTabEvent(radioGroup);
        initViewPagerEvent();
        return view;
    }

    private void initViewPagerEvent() {
        LatestReleaseFragment latestReleaseFragment = new LatestReleaseFragment();
        RewardMDFragment rewardMDFragment = new RewardMDFragment();
        AboutMeFragment aboutMeFragment = new AboutMeFragment();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(latestReleaseFragment);
        fragments.add(rewardMDFragment);
        fragments.add(aboutMeFragment);

        //ViewPager设置适配器
//        BaseFragmentPagerAdapter adapter = new BaseFragmentPagerAdapter(getFragmentManager(), fragments);
//        mViewPager.setAdapter(adapter);

        // ViewPager显示第一个Fragment
        mViewPager.setCurrentItem(0);

        //ViewPager页面切换监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                /*switch (position){
                    case 0:
                        radioGroup.check(R.id.rb_new_item);
//                        setTabText(rb_new_item);
                        break;
                    case 1:
                        radioGroup.check(R.id.rb_maidou);
//                        setTabText(rb_maidou);
                        break;
                    case 2:
                        radioGroup.check(R.id.rb_about_me);
//                        setTabText(rb_about_me);
                        break;
                }*/
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView(View view) {
        /*radioGroup = (RadioGroup) view.findViewById(R.id.rg_topic_tab);
        rb_new_item = (RadioButton) view.findViewById(R.id.rb_new_item);
        rb_maidou = (RadioButton) view.findViewById(R.id.rb_maidou);
        rb_about_me = (RadioButton) view.findViewById(R.id.rb_about_me);

        mViewPager = (ViewPager) view.findViewById(R.id.vp_topic_content);*/
    }

    private void initTabEvent(RadioGroup radioGroup) {
       /* radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_new_item:
                        //setCurrentItem的第二个参数控制页面切换动画
                        mViewPager.setCurrentItem(0, false);
//                        setTabText(rb_new_item);
                        break;
                    case R.id.rb_maidou:
                        mViewPager.setCurrentItem(1, false);
//                        setTabText(rb_maidou);
                        break;
                    case R.id.rb_about_me:
                        mViewPager.setCurrentItem(2, false);
//                        setTabText(rb_about_me);
                        break;
                }
            }
        });*/
    }

    private void setTabText(RadioButton radioButton) {
        radioButton.setTextColor(0x2ecdda);
    }
}
