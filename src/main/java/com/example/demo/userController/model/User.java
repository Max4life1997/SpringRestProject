package com.example.demo.userController.model;

import com.example.demo.userController.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private Long id;
    private String userName;
    private List<ToDo> toDoList;

    public static User toModel(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setUserName(userEntity.getUserName());
        user.setToDoList(userEntity.getToDoEntityList().stream().map(ToDo::toModel).collect(Collectors.toList()));
        return user;
    }

    public User() {
    }

    public List<ToDo> getToDoList() {
        return toDoList;
    }

    public void setToDoList(List<ToDo> toDoList) {
        this.toDoList = toDoList;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
