package com.example.delaynomore.service;

import com.example.delaynomore.entity.Task;
import com.example.delaynomore.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public Task startTask(Long id) {
        Task task = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Task not found"));

        if (task.isActive()) {
            throw new RuntimeException("Task is already active");
        }

        task.setLastStarted(LocalDateTime.now());
        task.setActive(true);
        return taskRepository.save(task);
    }
    @Transactional
    public Task stopTask(Long id) {
        Task task = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.isActive()) {
            return task;
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime lastStarted = task.getLastStarted();

        if (lastStarted != null) {
            long seconds = Duration.between(lastStarted, now).getSeconds();
            long currentTotal = task.getTotalSeconds() != null ? task.getTotalSeconds() : 0;
            task.setTotalSeconds(currentTotal + seconds);
        }

        task.setLastEnded(now);
        task.setActive(false);
        return taskRepository.save(task);
    }



    public List<Task> listAll() {
        return taskRepository.findAll();
    }

    
}
