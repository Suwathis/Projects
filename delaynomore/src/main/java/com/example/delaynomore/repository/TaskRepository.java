package com.example.delaynomore.repository;

import com.example.delaynomore.entity.Task;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
}

