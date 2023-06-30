package com.example.demo.userController.model;

import com.example.demo.userController.entity.ToDoEntity;
import com.example.demo.userController.entity.UserEntity;

public class ToDo {
    private Long id;
    private String title;
    private Boolean completed;

    public static ToDo toModel(ToDoEntity toDoEntity) {
        ToDo model = new ToDo();
        model.setId(toDoEntity.getId());
        model.setTitle(toDoEntity.getTitle());
        model.setCompleted(toDoEntity.getComleted());
        return model;
    }

    public ToDo() {
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
