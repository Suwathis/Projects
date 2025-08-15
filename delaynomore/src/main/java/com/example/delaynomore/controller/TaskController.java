package com.example.delaynomore.controller;

import com.example.delaynomore.entity.Task;
import com.example.delaynomore.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getTasks() {
        return taskService.listAll();
    }

    @PostMapping("/{id}/start")
    public ResponseEntity<?> startTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.startTask(id));
    }

    @PostMapping("/{id}/stop")
    public Task stopTask(@PathVariable Long id) {
        return taskService.stopTask(id);
    }
    

}