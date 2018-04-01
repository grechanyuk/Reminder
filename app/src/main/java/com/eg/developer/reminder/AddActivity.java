package com.eg.developer.reminder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    private static final int LAYOUT = R.layout.activity_add;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initToolbar();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_add);
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
        Toast.makeText(getApplicationContext(),"Типа добавилось", Toast.LENGTH_SHORT).show();
    }
}
