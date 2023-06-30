package com.example.demo.userController.controller;

import com.example.demo.userController.entity.ToDoEntity;
import com.example.demo.userController.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping
    public ResponseEntity createToDo(@RequestBody ToDoEntity toDo,
                                     @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(toDoService.createToDo(toDo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка при создании toDo " + e);
        }
    }

    @PutMapping
    public ResponseEntity completeToDo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(toDoService.complete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка при измении статуса complete " + e);
        }
    }

}
