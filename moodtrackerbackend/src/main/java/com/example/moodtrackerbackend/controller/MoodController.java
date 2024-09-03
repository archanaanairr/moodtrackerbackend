package com.example.moodtrackerbackend.controller;
import com.example.moodtrackerbackend.model.MoodEntry;
import com.example.moodtrackerbackend.service.MoodEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mood")
@CrossOrigin(origins = "http://localhost:3000")

public class MoodController {

    @Autowired
    private MoodEntryService moodEntryService;

    @PostMapping("/save")
    public ResponseEntity<MoodEntry> saveMoodEntry(@RequestBody MoodEntry moodEntry) {
        return new ResponseEntity<>(moodEntryService.saveMoodEntry(moodEntry), HttpStatus.CREATED);
    }

    @GetMapping("/weekly-report")
    public ResponseEntity<List<MoodEntry>> getWeeklyReport() {
        return new ResponseEntity<>(moodEntryService.getWeeklyReport(), HttpStatus.OK);
    }

    @GetMapping("/recommendations")
    public ResponseEntity<String> getRecommendations() {
        return new ResponseEntity<>(moodEntryService.generateRecommendations(), HttpStatus.OK);
    }

}