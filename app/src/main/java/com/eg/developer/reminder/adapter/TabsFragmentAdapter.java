package com.eg.developer.reminder.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.eg.developer.reminder.R;
import com.eg.developer.reminder.abstracts.AbstractTabFragment;
import com.eg.developer.reminder.extensions.Constants;
import com.eg.developer.reminder.fragments.BirthdaysFragment;
import com.eg.developer.reminder.fragments.HistoryFragment;
import com.eg.developer.reminder.fragments.IdeasFragment;
import com.eg.developer.reminder.fragments.ToDoFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Developer on 26.03.2018.
 */

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractTabFragment> tabs; //Массив с табами
    private Context context;

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle(); //По ключу находим
    }

    @Override
    public Fragment getItem(int position) {

        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    public TabsFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        initTabsMap(context);
    }

    private void initTabsMap(Context context) {
        tabs = new HashMap<>(); //Инициализируем Map'у
        tabs.put(Constants.TAB_HISTORY_POSITION, HistoryFragment.getInstance(context));
        tabs.put(Constants.TAB_IDEAS_POSITION, IdeasFragment.getInstance(context));
        tabs.put(Constants.TAB_TODO_POSITION, ToDoFragment.getInstance(context));
        tabs.put(Constants.TAB_BIRTHDAY_POSITION, BirthdaysFragment.getInstance(context));
    }
}
