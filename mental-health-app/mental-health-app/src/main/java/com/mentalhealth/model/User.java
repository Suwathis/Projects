package com.mentalhealth.model;

import jakarta.persistence.*;//Imports JPA annotations like @Entity, @Id, etc. used for mapping Java classes to database tables.
import java.time.LocalDate;//Java's built-in class for representing a date (without time).

@Entity//This tells Spring and JPA that this class maps to a database table.
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alias;

    private LocalDate createdAt = LocalDate.now();//This field saves the date when the user was created.
//LocalDate.now() automatically sets the current date when the object is created.

    // Getters and Setters
    public Long getId() { return id; }
    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }
    public LocalDate getCreatedAt() { return createdAt; }
}
//@Id: Marks this field as the primary key of the table.
//@GeneratedValue: Auto-generates the value for the primary key.
//strategy = GenerationType.IDENTITY: Uses the database’s built-in auto-increment.
