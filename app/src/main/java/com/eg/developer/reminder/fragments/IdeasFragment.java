package com.eg.developer.reminder.fragments;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eg.developer.reminder.DB.DBHelper;
import com.eg.developer.reminder.R;
import com.eg.developer.reminder.abstracts.AbstractTabFragment;
import com.eg.developer.reminder.adapter.RemindListAdapter;
import com.eg.developer.reminder.dto.RemindDTO;
import com.eg.developer.reminder.extensions.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer on 26.03.2018.
 */

public class IdeasFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_ideas;

    public static IdeasFragment getInstance(Context context) {
        Bundle args = new Bundle();
        IdeasFragment fragment = new IdeasFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.txtTabIdeas));

        return fragment;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        RecyclerView rv = view.findViewById(R.id.recyclerViewIdeas); //Сюда будут подгружаться задачи
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(new RemindListAdapter(localData())); //Сюда будем вставлять данные с SQLite

        return view;
    }

    private List<RemindDTO> localData() { //Имитация сервера
        List<RemindDTO> data = new ArrayList<>();

        DBHelper dbHelper = new DBHelper(this.context);
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(DBHelper.TABLE_REMINDERS, null, "category_id=" + Constants.IDEAS_CATEGORY_ID, null, null, null, null);

        if (cursor.moveToFirst()) {
            int remindIdIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int titleIndex = cursor.getColumnIndex(DBHelper.KEY_TITLE);
            int descriptionIndex = cursor.getColumnIndex(DBHelper.KEY_DESCRIPTION);
            do {
                data.add(new RemindDTO(cursor.getString(titleIndex), cursor.getString(descriptionIndex), cursor.getInt(remindIdIndex)));
            } while (cursor.moveToNext());
        } else {
            TextView textView = view.findViewById(R.id.noDataIdeas);
            textView.setText(R.string.txtNoDataIdeas);
            textView.setVisibility(View.VISIBLE);
        }
        return data;
    }
}
