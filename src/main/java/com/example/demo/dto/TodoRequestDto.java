package com.example.demo.dto;


import lombok.Getter;
import lombok.Setter;


public class TodoRequestDto {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public TodoRequestDto(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    private String title;
    private boolean completed;
}
