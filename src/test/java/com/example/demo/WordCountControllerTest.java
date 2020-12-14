package com.example.demo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;


@SpringBootTest
@AutoConfigureMockMvc

public class WordCountControllerTest {

    @Autowired
    MockMvc mvc;

//    @MockBean
//    ConfigClass config;

    @Test
    public void testWordCounter() throws Exception {
//        config.countThis();
        String testString = "to the moon, to the moon!";
        MockHttpServletRequestBuilder request = post("/words/count")
//                .contentType(MediaType.TEXT_PLAIN)
                .content(testString);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.to", is(2)))
                .andExpect(jsonPath("$.the", is(2)))
                .andExpect(jsonPath("$.moon", is(2)));

    }
}
