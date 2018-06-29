package com.example.windows.chatwith.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.windows.chatwith.R;
import com.example.windows.chatwith.fragments.ForumFragment;
import com.example.windows.chatwith.fragments.WXChartFragment;

import java.util.ArrayList;

/**
 * Created by Windows on 2018/6/29.
 */

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ArrayList<Fragment> mFragmentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);


        mFragmentList = new ArrayList<>();
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        initView();
    }

    private void initView() {
        mFragmentList.add(new WXChartFragment());
        mFragmentList.add(new ForumFragment());

        mViewPager.setCurrentItem(0);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        });
    }
}
