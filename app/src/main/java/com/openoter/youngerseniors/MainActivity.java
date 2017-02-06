package com.openoter.youngerseniors;

import android.support.annotation.StringDef;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.openoter.youngerseniors.base.BaseActivity;
import com.openoter.youngerseniors.fragment.FindFragment;
import com.openoter.youngerseniors.fragment.FriendFragment;
import com.openoter.youngerseniors.fragment.MineFragment;
import com.openoter.youngerseniors.fragment.TopicFragment;

public class MainActivity extends BaseActivity {

    private Class arrFragment[] = {
            TopicFragment.class,
            FindFragment.class,
            FriendFragment.class,
            MineFragment.class
    };

    private String arrText[] = {
            "话题",
            "发现",
            "辈友",
            "我"
    };


    private int arrImageRes[] = {
        R.drawable.selector_topic,
        R.drawable.selector_find,
        R.drawable.selector_friend,
        R.drawable.selector_mine
    };

    private FragmentTabHost mTabHost;

    private LayoutInflater mInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mInflater = LayoutInflater.from(this);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.fl_content);

        for (int i = 0; i < arrFragment.length; i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(arrText[i]).setIndicator(getViewItem(i));
            mTabHost.addTab(tabSpec, arrFragment[i], null);
//            mTabHost
        }
    }

    private View getViewItem(int i) {
        View view = mInflater.inflate(R.layout.main_tab, null);
        ImageView tv_pic = (ImageView) view.findViewById(R.id.iv_pic);
        TextView tv_tit = (TextView) view.findViewById(R.id.tv_tit);

        tv_pic.setBackgroundResource(arrImageRes[i]);
        tv_tit.setText(arrText[i]);
        return view;
    }


}
