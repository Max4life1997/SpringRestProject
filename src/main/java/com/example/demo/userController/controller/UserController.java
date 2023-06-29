package com.example.demo.userController.controller;

import com.example.demo.userController.entity.UserEntity;
import com.example.demo.userController.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserEntity user) {
        try {
            userRepo.save(user);
            return ResponseEntity.ok("Пользователь создан: " + "id:" + user.getId() + " username" + user.getUserName());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка " + e);
        }
    }

    @GetMapping
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok("Сервер работает");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка " + e);
        }
    }
}
