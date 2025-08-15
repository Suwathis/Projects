package com.example.delaynomore.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  

    private boolean active;

    @Column(name = "last_started")
    private LocalDateTime lastStarted;

    @Column(name = "last_ended")
    private LocalDateTime lastEnded;

    @Column(name = "total_seconds")
    private Long totalSeconds = 0L;

    @Column(name = "cooldown_minutes")
    private int cooldownMinutes = 0;

    
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getLastStarted() {
        return lastStarted;
    }
    public void setLastStarted(LocalDateTime lastStarted) {
        this.lastStarted = lastStarted;
    }

    public LocalDateTime getLastEnded() {
        return lastEnded;
    }
    public void setLastEnded(LocalDateTime lastEnded) {
        this.lastEnded = lastEnded;
    }

    public Long getTotalSeconds() {
        return totalSeconds;
    }
    public void setTotalSeconds(Long totalSeconds) {
        this.totalSeconds = totalSeconds;
    }

    public int getCooldownMinutes() {
        return cooldownMinutes;
    }
    public void setCooldownMinutes(int cooldownMinutes) {
        this.cooldownMinutes = cooldownMinutes;
    }
}
