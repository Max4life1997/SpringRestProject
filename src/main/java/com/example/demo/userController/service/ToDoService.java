package com.example.demo.userController.service;

import com.example.demo.userController.entity.ToDoEntity;
import com.example.demo.userController.entity.UserEntity;
import com.example.demo.userController.model.ToDo;
import com.example.demo.userController.repository.ToDoRepo;
import com.example.demo.userController.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepo toDoRepo;

    @Autowired
    private UserRepo userRepo;

    public ToDo createToDo(ToDoEntity toDoEntity, Long userId) {
        UserEntity userEntity = userRepo.findById(userId).get();
        toDoEntity.setUser(userEntity);
        Assert.notNull(toDoEntity.getTitle(), "Поле title заполнено некорректно title:" + toDoEntity.getTitle());
        Assert.notNull(toDoEntity.getComleted(), "Поле completed заполнено некорректно completed:" + toDoEntity.getComleted());
        return ToDo.toModel(toDoRepo.save(toDoEntity));
    }

    public ToDo complete(Long id) {
        ToDoEntity toDoEntity = toDoRepo.findById(id).get();
        toDoEntity.setCompleted(!toDoEntity.getComleted());
        return ToDo.toModel(toDoRepo.save(toDoEntity));
    }

}
