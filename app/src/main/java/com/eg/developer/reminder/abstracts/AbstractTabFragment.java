package com.eg.developer.reminder.abstracts;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Developer on 27.03.2018.
 */

public class AbstractTabFragment extends Fragment {
    private String title;

    protected Context context; // protected - можем без геттеров и сеттеров использовать переменную в классах, ктотрые наследуют этот абстракт. Переменные и методы для этих классов общие!
    protected View view;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
