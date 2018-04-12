package com.eg.developer.reminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.eg.developer.reminder.adapter.TabsFragmentAdapter;
import com.eg.developer.reminder.extensions.Constants;

/**
 * Created by Developer on 26.03.2018.
 */

public class MainActivity extends AppCompatActivity {

    private static final int LAYOUT = R.layout.activity_main; //Так тоже можно, потому что каждый layout имеет свой id.
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppDefault); //Указываем какую тему использовать приложению
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initToolbar(); //Инициализируем кастомный тулбар(там, где кнопка поиск).
        initNavigationView(); //Инизиализируем навигацию
        initTabs();
    }

    private void initTabs() {
        viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        TabsFragmentAdapter adapter = new TabsFragmentAdapter(this, getSupportFragmentManager()); //this - потому что находимся в активити
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initNavigationView() {
        drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.txtNavigationOpen, R.string.txtNavigationClose); //Создает бургер меню
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState(); //Держит Табы и элементы из бокового меню в синхроне

        NavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) { //Открываем нужную табу по клику на элемент бокового меню
                drawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.navigationIdeas:
                        showNotificationTab(Constants.TAB_IDEAS_POSITION);
                        break;
                    case R.id.navigationHistory:
                        showNotificationTab(Constants.TAB_HISTORY_POSITION);
                        break;
                    case R.id.navigationBirthday:
                        showNotificationTab(Constants.TAB_BIRTHDAY_POSITION);
                        break;
                    case R.id.navigationToDo:
                        showNotificationTab(Constants.TAB_TODO_POSITION);
                        break;
                }
                return true;
            }
        });
    }

    public void addRemind(View view) {
        Intent addRemind = new Intent(getApplicationContext(), AddActivity.class);
        startActivity(addRemind);
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });

        toolbar.inflateMenu(R.menu.menu);
    }

    private void showNotificationTab(int position) { //Выполняет переход на табу "Напоминания"
        viewPager.setCurrentItem(position);
    }
}
