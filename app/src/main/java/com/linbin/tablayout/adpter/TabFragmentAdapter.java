package com.linbin.tablayout.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by linbin_dian91 on 2016/3/15.
 */
public class TabFragmentAdapter extends FragmentStatePagerAdapter{
    private List<Fragment> mFragments;
    private List<String> mTitles;

    public  TabFragmentAdapter(FragmentManager fm,List<Fragment> fragments, List<String> titles){
        super(fm);
        mFragments = fragments;
        mTitles = titles;
    }
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
