package com.pratiksymz.android.courtcounter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CourtCounterFragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    //Public constructor for the ViewPager Adapter
    public CourtCounterFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // Set the Fragments as ViewPager items
        // And else is required!!
        if (position == 0) {
            return new CounterFragment();
        } else {
            return new StopwatchFragment();
        }
    }

    @Override
    public int getCount() {
        // Returns the number of items of the Viewpager
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //Set the titles of the tabs for the TabLayout
        if (position == 0) {
            return mContext.getString(R.string.counter_fragment);
        } else {
            return mContext.getString(R.string.stopwatch_fragment);
        }
    }
}