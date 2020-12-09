package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.HashMap;

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

//    @Test
//    public void testJSONCerealFlavor() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        HashMap<String, String> name1 = new HashMap<>() {
//            {
//                put("firstName", "Some name");
//                put("lastName", "Some other name");
//            }
//        };
//        HashMap<String, String> name2 = new HashMap<>() {
//            {
//                put("firstName", "Name B");
//                put("lastName", "Name C");
//            }
//        };
//         HashMap<String, Object> ticket1 = new HashMap<String, Object>(){  // 2
//            {
//                put("passenger", name1);
//                put("price", "200");
//            }
//        };
//        HashMap<String, Object> ticket2 = new HashMap<String, Object>(){  // 2
//            {
//                put("passenger", name2);
//                put("price", "150");
//            }
//        };
//
//        HashMap<String, Object> tickets = new HashMap<String, Object>(){  // 2
//            {
//                put("passenger", name2);
//                put("price", "150");
//            }
//        };
//
//        String json = objectMapper.writeValueAsString(tickets);            // 3
//
//        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json);                                         // 4
//
//        this.mvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().string("{\"result\":350}"));
//    }
}

