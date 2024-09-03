package com.example.moodtrackerbackend.service;

import com.example.moodtrackerbackend.model.MoodEntry;
import com.example.moodtrackerbackend.repository.MoodEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;


@Service
public class MoodEntryService {

    @Autowired
    private MoodEntryRepository moodEntryRepository;

    public MoodEntry saveMoodEntry(MoodEntry moodEntry) {

        return moodEntryRepository.save(moodEntry);
    }

    public List<MoodEntry> getWeeklyReport() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(7);
        return moodEntryRepository.findByEntryDateBetween(startDate, endDate);
    }

    public String generateRecommendations() {

        List<MoodEntry> weeklyReport = getWeeklyReport();
        if (weeklyReport.isEmpty()) {
            return "No data available for recommendations.";
        }

        int totalMood = weeklyReport.stream().mapToInt(MoodEntry::getMoodScore).sum();
        int averageMood = totalMood / weeklyReport.size();

        if (averageMood <= 3) {
            return "Consider seeking help from a mental health professional.";
        } else if (averageMood <= 6) {
            return "Try incorporating relaxation techniques and ensuring you get adequate rest.";
        } else {
            return "Keep up the good mood! Continue doing what makes you feel good.";
        }
    }

}