package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WordCounterController {

    private WordCounter result;

    public WordCounterController (WordCounter result) {
        this.result = result;
    }

    @PostMapping("/words/count")
    public Map<String, Integer> postWordCount (@RequestBody String input) {
        return result.count(input);
    }
}
