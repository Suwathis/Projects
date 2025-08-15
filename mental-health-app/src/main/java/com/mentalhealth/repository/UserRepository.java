package com.mentalhealth.repository;

import com.mentalhealth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByAlias(String alias);
}
//User: Refers to the entity class you're performing operations on.
//JpaRepository: A Spring interface that provides many ready-to-use methods to work with the database.
//Optional: A wrapper for values that might be null. Helps avoid NullPointerException.
//This line tells Spring:UserRepository is a JPA repository for the User entity.
//Long is the type of the primary key (id in User class).
//Because of this, you get many methods for free, like:
//userRepo.findAll();           // Get all users
//userRepo.findById(1L);        // Find a user by ID
//userRepo.save(user);          // Save or update a user
//userRepo.deleteById(1L);      // Delete user by ID
//It means: “Find a user where alias = ?”
//It returns an Optional<User>:
//If user is found → Optional contains a User
//If not found → it's empty