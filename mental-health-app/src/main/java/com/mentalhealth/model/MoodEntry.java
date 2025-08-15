package com.mentalhealth.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class MoodEntry {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne//the @ManyToOne relationship in your MoodEntry class creates a foreign key in the database.
    
    private User user;

    private String mood;
    private String description;
    private LocalDate date = LocalDate.now();

    // Getters and Setters
    public void setUser(User user) { this.user = user; }
    public void setMood(String mood) { this.mood = mood; }
    public void setDescription(String description) { this.description = description; }
    
    
    
}
//LocalDate: A class that stores only the date (no time) from the Java standard library.
//@ManyToOne
//private User user;
//This creates a many-to-one relationship between MoodEntry and User.
//That means one user can have many mood entries, but each MoodEntry belongs to only one user.
//When you run your Spring Boot app with this entity setup, Hibernate (or JPA provider) automatically creates a database table
//user_id is added automatically because of the @ManyToOne annotation.
//It references the id column in the user table (which is the primary key of the User entity).
//A foreign key is a column in one table that refers to the primary key of another table.
//In your case:mood_entry.user_id → points to → user.id



