package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


public class Flights {
    @JsonProperty("Departs")
    private Date departs;
    @JsonProperty("Tickets")
    private Ticket tickets;

    @JsonFormat(pattern = "yyyy-MM-dd HH:MM")
    public Date getDeparts() {return departs;}
    public void setDeparts(Date departs) {this.departs = departs;}

    public Ticket getTickets() {return tickets;}
    public void setTickets(Ticket tickets) {this.tickets = tickets;}

    static class Ticket {
        @JsonProperty("Passenger")
        private Passenger passenger;
        @JsonProperty("Price")
        private int price;
//        private List<Passenger> passengerList;

        public int getPrice() {return price;}
        public void setPrice(int price) {this.price = price;}

        public Passenger getPassenger() { return passenger; }
        public void setPassenger(Passenger passenger) { this.passenger = passenger; }

//        public List<Passenger> getPassengerList() {return passengerList;}
//        public void setPassengerList(List<Passenger> passengerList) {this.passengerList = passengerList;}

        static class Passenger {
            @JsonProperty("FirstName")
            private String firstName;
            @JsonProperty("LastName")
            private String lastName;

            @JsonInclude(JsonInclude.Include.NON_NULL)
            public String getFirstName() {return firstName;}
            public void setFirstName(String firstName) {this.firstName = firstName;}

            @JsonInclude(JsonInclude.Include.NON_NULL)
            public String getLastName() {return lastName; }
            public void setLastName(String lastName) {this.lastName = lastName; }
        }
    }




}
