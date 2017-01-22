package com.xct.nevermore.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RelativeLayout;

import com.xct.nevermore.myapplication.base.BaseActivity;
import com.xct.nevermore.myapplication.fragment.FamousFragment;
import com.xct.nevermore.myapplication.ui.PagerSlidingTabStrip;

import java.util.ArrayList;

import butterknife.Bind;

public class PagerSlideActivity extends BaseActivity {


    @Bind(R.id.pager_strip)
    PagerSlidingTabStrip pagerStrip;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.activity_pager_slide)
    RelativeLayout activityPagerSlide;
    private String[] names;
    private ArrayList<Fragment> fragments;

    @Override
    public int getRootViewId() {
        return R.layout.activity_pager_slide;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        names = new String[]{"西游记","水浒传","三国演","红楼梦"};
        fragments = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {

            FamousFragment fragment = FamousFragment.newInstance(names[i]);

            fragments.add(fragment);
        }

        BookAdapter bookAdapter = new BookAdapter(getSupportFragmentManager());
        viewPager.setAdapter(bookAdapter);
        pagerStrip.setViewPager(viewPager);

    }

    class BookAdapter extends FragmentPagerAdapter{

        public BookAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return names[position];
        }
    }





}
