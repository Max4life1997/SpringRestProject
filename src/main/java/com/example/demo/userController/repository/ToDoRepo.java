package com.example.demo.userController.repository;

import com.example.demo.userController.entity.ToDoEntity;
import com.example.demo.userController.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;


public interface ToDoRepo extends CrudRepository<ToDoEntity, Long> {
}
