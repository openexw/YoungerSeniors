package com.openoter.youngerseniors.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.openoter.youngerseniors.R;


public class AboutMeFragment extends Fragment implements View.OnClickListener{
    private RelativeLayout rl_friend_topic_school,
            rl_friend_topic_th,
            rl_my_question,
            rl_my_answer,
            rl_adopt;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topic_about_me, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rl_friend_topic_school = (RelativeLayout) view.findViewById(R.id.rl_friend_topic_school);
        rl_friend_topic_th = (RelativeLayout) view.findViewById(R.id.rl_friend_topic_th);
        rl_my_question = (RelativeLayout) view.findViewById(R.id.rl_my_question);
        rl_my_answer = (RelativeLayout) view.findViewById(R.id.rl_my_answer);
        rl_adopt = (RelativeLayout) view.findViewById(R.id.rl_adopt);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_friend_topic_school:
                break;
            case R.id.rl_friend_topic_th:
                break;
            case R.id.rl_my_question:
                break;
            case R.id.rl_my_answer:
                break;
            case R.id.rl_adopt:
                break;
        }
    }
}
