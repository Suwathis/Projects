package com.mentalhealth.repository;

import com.mentalhealth.model.MoodTip;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MoodTipRepository extends JpaRepository<MoodTip, Long> {
    List<MoodTip> findByMood(String mood);
}

