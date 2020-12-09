package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JSONResponseController.class)
public class FlightTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testJSONFlight() throws Exception {
        this.mvc.perform(
                get("/flights/flight")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departs", is("2017-04-21 07:04")))
                .andExpect(jsonPath("$.tickets.passenger.firstName", is("Some name")))
                .andExpect(jsonPath("$.tickets.passenger.lastName", is("Some other name")))
                .andExpect(jsonPath("$.tickets.price", is(200)));
    }

    @Test
    public void testJSONFlightMorethanOne() throws Exception {
        this.mvc.perform(
                get("/flights")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.departs", is("2017-04-21 07:04")))
//                .andExpect(jsonPath("$.tickets.passenger.firstName", is("Some name")))
//                .andExpect(jsonPath("$.tickets.passenger.lastName", is("Some other name")))
                .andExpect(jsonPath("$[0].tickets.price", is(200)))
                .andExpect(jsonPath("$[1].tickets.price", is(400)));
    }

    @Test
    public void testJSONFlightCaps() throws Exception {
        this.mvc.perform(
                get("/flights")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.departs", is("2017-04-21 07:04")))
//                .andExpect(jsonPath("$.tickets.passenger.firstName", is("Some name")))
//                .andExpect(jsonPath("$.tickets.passenger.lastName", is("Some other name")))
                .andExpect(jsonPath("$[0].Tickets[0].Price", is(200)))
                .andExpect(jsonPath("$[1].Tickets[0].Price", is(400)));
    }

}
