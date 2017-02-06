package com.openoter.youngerseniors.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<String> titles;
    private List<Fragment> fragments;
    public BaseFragmentPagerAdapter(FragmentManager fm, ArrayList<String> titles, List<Fragment> list) {
        super(fm);
        this.titles = titles;
        this.fragments = list;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
