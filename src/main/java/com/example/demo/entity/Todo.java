package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String title;

    private boolean completed;

    public Todo() {}

    public Todo(String tile , boolean completed){
        this.title = tile;
        this.completed =completed;
    }


    public Long getId() {
        return id;
    }

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


}
