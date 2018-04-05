package com.eg.developer.reminder;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.eg.developer.reminder.DB.DBHelper;

public class AddActivity extends AppCompatActivity {

    private static final int LAYOUT = R.layout.activity_add;

    private SQLiteDatabase sqLiteDatabase;

    private String title;
    private String description;
    private int category_id;

    @Override
    protected void onStop() {
        super.onStop();
        if(title != "" && description != "" && category_id != 0)
            insertToDB();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_add);
        toolbar.setTitle(R.string.txtAdd);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                addRemind();
                return true;
            }
        });

        toolbar.inflateMenu(R.menu.menu_add);
    }

    private void addRemind() {
        EditText title = findViewById(R.id.addTitleRemind);
        EditText description = findViewById(R.id.addDescriptionRemind);

        this.title = title.getText().toString();
        this.description = description.getText().toString();
        this.category_id = 1;

        Toast.makeText(getApplicationContext(),"Типа добавилось", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void insertToDB() {
        DBHelper dbHelper = new DBHelper(this);
        sqLiteDatabase = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.KEY_TITLE, title);
        contentValues.put(DBHelper.KEY_DESCRIPTION, description);
        contentValues.put(DBHelper.KEY_CATEGORY_ID, category_id);

        sqLiteDatabase.insert(DBHelper.TABLE_REMINDERS, null, contentValues);
        sqLiteDatabase.close();
    }
}
