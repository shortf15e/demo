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
    public Flights getFlight() {
        Flights testFlight = new Flights();
        Flights.Ticket ticket = new Flights.Ticket();
        List<Flights.Ticket.Passenger> passengers = new ArrayList<>();
        Flights.Ticket.Passenger passenger = new Flights.Ticket.Passenger();

        testFlight.setDeparts(new Date(117, 3, 21));
        passenger.setFirstName("Some name");
        passenger.setLastName("Some other name");
        passengers.add(passenger);
        ticket.setPassenger(passenger);
        ticket.setPrice(200);
        testFlight.setTickets(ticket);

        System.out.println();

        return testFlight;
    }

    @GetMapping("/flights")
    public List<Flights> getFlightS() {
        List<Flights> testFlights = new ArrayList<>();
        Flights testFlight1 = new Flights();
        Flights testFlight2 = new Flights();
        Flights.Ticket ticket1 = new Flights.Ticket();
        Flights.Ticket ticket2 = new Flights.Ticket();
        List<Flights.Ticket.Passenger> passengers = new ArrayList<>();
        Flights.Ticket.Passenger passenger1 = new Flights.Ticket.Passenger();
        Flights.Ticket.Passenger passenger2 = new Flights.Ticket.Passenger();

        //testFlight1
        testFlight1.setDeparts(new Date(117, 3, 21));
        passenger1.setFirstName("Some name");
        passenger1.setLastName("Some other name");

        ticket1.setPassenger(passenger1);
        ticket1.setPrice(200);
        testFlight1.setTickets(ticket1);
        testFlights.add(testFlight1);

        //testFlight2
        testFlight2.setDeparts(new Date(117, 3, 21));
        passenger2.setFirstName("Some other name");

        ticket2.setPassenger(passenger2);
        ticket2.setPrice(400);
        testFlight2.setTickets(ticket2);
        testFlights.add(testFlight2);



        return testFlights;
    }
}
