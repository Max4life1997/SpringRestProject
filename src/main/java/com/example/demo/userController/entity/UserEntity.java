package com.example.demo.userController.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "todo")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<ToDoEntity> toDoEntityList;

    public UserEntity() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ToDoEntity> getToDoEntityList() {
        return toDoEntityList;
    }

    public void setToDoEntityList(List<ToDoEntity> toDos) {
        this.toDoEntityList = toDos;
    }
}
