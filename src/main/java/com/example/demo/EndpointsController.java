package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndpointsController {

    @GetMapping("/")
    public String getIndex() {
        return "GET to index route";
    }

    @GetMapping("/tasks")
    public String getTasks () {
        return "These are the tasks";
    }

    @PostMapping("/tasks")
    public String createTask() {
        return "You just POSTed to /tasks";
    }

    @GetMapping("/math/pi")
    public String getPi() {
        return "3.141592653589793";
    }
}
