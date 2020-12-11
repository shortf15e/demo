package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {

        return this.repository.save(lesson);
    }

    @GetMapping("/{id}")
    public Lesson getLessonById (@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deleteLessonById (@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PatchMapping("/{id}")
    public void updateLessonById(@PathVariable Long id, @RequestBody Lesson lesson) {
        Lesson tempLesson  = repository.findById(id).get();
        if (!repository.findById(id).equals(lesson)) {
            if (!tempLesson.getDeliveredOn().equals(lesson.getDeliveredOn())){
                tempLesson.setDeliveredOn(lesson.getDeliveredOn());
            }
            if (!tempLesson.getId().equals(lesson.getId())) {
                tempLesson.setId(lesson.getId());
            }
            if (!tempLesson.getTitle().equals(lesson.getTitle())) {
                tempLesson.setTitle(lesson.getTitle());
            }
            this.repository.save(tempLesson);
        }
    }

}
