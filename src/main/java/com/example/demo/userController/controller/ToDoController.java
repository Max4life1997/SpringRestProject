package com.example.demo.userController.controller;

import com.example.demo.userController.entity.ToDoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    @PostMapping
    public ResponseEntity createToDo(@RequestBody ToDoEntity toDo,
                                     @RequestParam Long userId) {
        try {

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @PutMapping
    public ResponseEntity completeToDo(@RequestParam Long id) {
        try {

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

}
