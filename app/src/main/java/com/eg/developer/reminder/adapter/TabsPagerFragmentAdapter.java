package com.eg.developer.reminder.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.eg.developer.reminder.fragments.ExampleFragment;

/**
 * Created by Developer on 26.03.2018.
 */

public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {

    private String[] tabs; //Массив с табами

    public TabsPagerFragmentAdapter(FragmentManager fm) {
        super(fm);

        tabs = new String[] {
            "Tab 1",
            "Напоминания",
            "Tab 2"
        };
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ExampleFragment.getInstance();
            case 1:
                return ExampleFragment.getInstance();
            case 2:
                return ExampleFragment.getInstance();
        }

        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
