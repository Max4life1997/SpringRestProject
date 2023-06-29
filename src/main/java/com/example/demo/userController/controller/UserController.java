package com.example.demo.userController.controller;

import com.example.demo.userController.entity.UserEntity;
import com.example.demo.userController.exceptions.UserAlreadyExistException;
import com.example.demo.userController.exceptions.UserNotFoundException;
import com.example.demo.userController.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь создан: " + "id:" + user.getId() + " username" + user.getUserName());
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body("Ошибка " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка " + e);
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body("Ошибка " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка " + e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка: Пользователь не найден в базе " + e);
        }
    }
}
