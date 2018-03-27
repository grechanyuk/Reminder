package com.eg.developer.reminder.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eg.developer.reminder.R;
import com.eg.developer.reminder.abstracts.AbstractTabFragment;

/**
 * Created by Developer on 26.03.2018.
 */

public class ToDoFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_example;

    public static ToDoFragment getInstance(Context context) {
        Bundle args = new Bundle();
        ToDoFragment fragment = new ToDoFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.txtTabToDo));

        return fragment;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        return view;
    }
}
