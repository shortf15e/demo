package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(EndpointsController.class)

public class TicketTotalTest {

    @Autowired
    MockMvc mvc;

    @Test //flights/tickets/total
    public void testJSONStringLiteral() throws Exception {
        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content("  {\n" +
                        "    \"tickets\": [\n" +
                        "      {\n" +
                        "        \"passenger\": {\n" +
                        "          \"firstName\": \"Some name\",\n" +
                        "          \"lastName\": \"Some other name\"\n" +
                        "        },\n" +
                        "        \"price\": 200\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"passenger\": {\n" +
                        "          \"firstName\": \"Name B\",\n" +
                        "          \"lastName\": \"Name C\"\n" +
                        "        },\n" +
                        "        \"price\": 150\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  }");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"result\":350}"));
    }

    @Test //flights/tickets/total
    public void testJSONFileRead() throws Exception {
        String json = getJSON("/Ticket_Total.json");
        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);


        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"result\":350}"));
    }

    private String getJSON(String path) throws Exception{
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }

    @Test
    public void testJSONCerealFlavor() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, String> name1 = new HashMap<>() {
            {
                put("firstName", "Some name");
                put("lastName", "Some other name");
            }
        };
        HashMap<String, String> name2 = new HashMap<>() {
            {
                put("firstName", "Name B");
                put("lastName", "Name C");
            }
        };
         HashMap<String, Object> ticket1 = new HashMap<>(){  // 2
            {
                put("passenger", name1);
                put("price", 200);
            }
        };
        HashMap<String, Object> ticket2 = new HashMap<>(){  // 2
            {
                put("passenger", name2);
                put("price", 150);
            }
        };
        List<Object> tickets = new ArrayList<Object>();
        tickets.add(ticket1);
        tickets.add(ticket2);
        HashMap<String, Object> flight = new HashMap<String, Object>(){  // 2
            {
                put("tickets", tickets);
            }
        };

        String json = objectMapper.writeValueAsString(flight);            // 3
        System.out.println(json);
        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);                                         // 4

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"result\":350}"));
    }
}

