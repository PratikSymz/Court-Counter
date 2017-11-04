package com.pratiksymz.android.courtcounter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CourtCounterFragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private Bundle counterFragmentBundle;

    // Public constructor for the ViewPager Adapter
    public CourtCounterFragmentAdapter(FragmentManager fm, Context context, Bundle bundle) {
        super(fm);
        mContext = context;
        counterFragmentBundle = bundle;
    }

    @Override
    public Fragment getItem(int position) {
        // Set the Fragments as ViewPager items
        // And else is required!!
        if (position == 0) {
            CounterFragment fragment = new CounterFragment();
            fragment.setArguments(counterFragmentBundle);
            return fragment;
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