package com.mentalhealth.model;

import jakarta.persistence.*;

@Entity
public class MoodTip {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mood;
    private String tipText;

    // Getters and Setters
    public String getTipText() { return tipText; }
}
