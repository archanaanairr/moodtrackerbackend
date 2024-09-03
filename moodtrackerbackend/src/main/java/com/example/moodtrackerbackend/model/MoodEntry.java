package com.example.moodtrackerbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MoodEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int moodScore;

    @Column(length = 1000)
    private String journalEntry;

    private int sleepHours;

    private int waterIntake;

    private LocalDate entryDate;

}
