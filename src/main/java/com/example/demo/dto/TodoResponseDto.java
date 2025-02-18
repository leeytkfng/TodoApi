package com.example.demo.dto;

import com.example.demo.entity.Todo;
import lombok.Getter;

public class TodoResponseDto {
    private Long id;
    private String title;
    private boolean completed;

    public TodoResponseDto(Long id, String title, boolean completed){
        this.id= id;
        this.title = title;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

}
