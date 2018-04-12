package com.eg.developer.reminder.dto;

/**
 * Created by Developer on 27.03.2018.
 */

public class RemindDTO {
    private String title;
    private String description;
    private int category_id;

    public RemindDTO(String title, String description, int category_id) {
        this.title = title;
        this.description = description;
        this.category_id = category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
