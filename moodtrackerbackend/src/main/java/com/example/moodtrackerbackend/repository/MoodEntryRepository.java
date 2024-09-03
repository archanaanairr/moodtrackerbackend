package com.example.moodtrackerbackend.repository;


import com.example.moodtrackerbackend.model.MoodEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MoodEntryRepository extends JpaRepository<MoodEntry, Long> {
    List<MoodEntry> findByEntryDateBetween(LocalDate startDate, LocalDate endDate);


}

