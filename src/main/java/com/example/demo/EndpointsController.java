package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

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

    @PostMapping("/flights/tickets/total")
    public HashMap<String, Integer> postTicketPrice (@RequestBody Flight flight ) {
        int sum =0;
        for (Ticket ticket : flight.getTickets()) {
            sum += ticket.getPrice();
        }
        HashMap<String, Integer> result = new HashMap<>();
        result.put("result", sum);
        return result;
    }
}
