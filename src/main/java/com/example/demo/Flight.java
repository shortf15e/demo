package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;


public class Flight {
//    @JsonProperty("Departs")
    private Date departs;
//    @JsonProperty("Tickets")
    private List<Ticket> tickets;

    @JsonFormat(pattern = "yyyy-MM-dd HH:MM")
    public Date getDeparts() {return departs;}
    public void setDeparts(Date departs) {this.departs = departs;}

    public List<Ticket> getTickets() {return tickets;}
    public void setTickets(List<Ticket> tickets) {this.tickets = tickets;}


}





