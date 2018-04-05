package com.eg.developer.reminder.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "remindapp";
    public static final String TABLE_REMINDERS = "reminders";

    public static final String KEY_ID = "_remind_id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_CATEGORY_ID = "category_id";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) { //Вызывается, если БД не существует и ее надо создать
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_REMINDERS + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_TITLE + " text, " + KEY_DESCRIPTION + " text, " + KEY_CATEGORY_ID + " integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { //Вызывается при обновлении версии БД
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_REMINDERS);
        this.onCreate(sqLiteDatabase);
    }
}
