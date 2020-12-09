package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class JSONResponseController {

    @GetMapping("/flights/flight")
    public Flight getFlight() {
        Flight testFlight = new Flight();
        Ticket ticket = new Ticket();
        List<Ticket> tickets = new ArrayList<>();
        List<Ticket.Passenger> passengers = new ArrayList<>();
        Ticket.Passenger passenger = new Ticket.Passenger();

        testFlight.setDeparts(new Date(117, 3, 21));
        passenger.setFirstName("Some name");
        passenger.setLastName("Some other name");
        passengers.add(passenger);
        ticket.setPassenger(passenger);
        ticket.setPrice(200);
        tickets.add(ticket);
        testFlight.setTickets(tickets);

        System.out.println();

        return testFlight;
    }

    @GetMapping("/flights")
    public List<Flight> getFlightS() {
        List<Flight> testFlights = new ArrayList<>();
        Flight testFlight1 = new Flight();
        Flight testFlight2 = new Flight();
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        List<Ticket> tickets1 = new ArrayList<>();
        List<Ticket> tickets2 = new ArrayList<>();
        List<Ticket.Passenger> passengers = new ArrayList<>();
        Ticket.Passenger passenger1 = new Ticket.Passenger();
        Ticket.Passenger passenger2 = new Ticket.Passenger();

        //testFlight1
        testFlight1.setDeparts(new Date(117, 3, 21));
        passenger1.setFirstName("Some name");
        passenger1.setLastName("Some other name");

        ticket1.setPassenger(passenger1);
        ticket1.setPrice(200);
        tickets1.add(ticket1);
        testFlight1.setTickets(tickets1);
        testFlights.add(testFlight1);

        //testFlight2
        testFlight2.setDeparts(new Date(117, 3, 21));
        passenger2.setFirstName("Some other name");
        ticket2.setPassenger(passenger2);
        ticket2.setPrice(400);
        tickets2.add(ticket2);
        testFlight2.setTickets(tickets2);
        testFlights.add(testFlight2);

        return testFlights;
    }
}
