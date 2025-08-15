package com.mentalhealth.repository;

import com.mentalhealth.model.MoodEntry;
import com.mentalhealth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MoodEntryRepository extends JpaRepository<MoodEntry, Long> {
    List<MoodEntry> findByUserOrderByDateDesc(User user);
    
}
