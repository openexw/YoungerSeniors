package com.openoter.youngerseniors.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.openoter.youngerseniors.R;
import com.openoter.youngerseniors.weight.ONToolbar;


public class AdvanceSearchActivity extends com.openoter.youngerseniors.base.BaseActivity{
    private ONToolbar mToolbar;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_search);

        mToolbar = (ONToolbar) findViewById(R.id.toolbar);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
