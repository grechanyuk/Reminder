package com.eg.developer.reminder.dto;

/**
 * Created by Developer on 27.03.2018.
 */

public class RemindDTO {
    private String title;

    public RemindDTO(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
