package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import javax.transaction.Transactional;

import java.util.Date;


import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LessonsControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    LessonRepository repository;

    @Test
    @Transactional
    @Rollback
    public void testGetLessonByID() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setId(1L);
        lesson.setDeliveredOn(new Date());
        lesson.setTitle("Test Title");
        repository.save(lesson);

        MockHttpServletRequestBuilder request = post("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"id\": 3,\n" +
                        "    \"title\": \"Bellman Ford\",\n" +
                        "    \"deliveredOn\": \"2017-05-02\"\n" +
                        "}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", instanceOf(Number.class)));
    }

    @Test
    @Transactional
    public void patchGetLessonByID() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setId(1L);
        lesson.setDeliveredOn(new Date());
        lesson.setTitle("Test Title");
        repository.save(lesson);

        lesson.setId(2L);
        lesson.setDeliveredOn(new Date());
        lesson.setTitle("Test Title 2");
        repository.save(lesson);

        lesson.setId(3L);
        lesson.setDeliveredOn(new Date());
        lesson.setTitle("Test Title 3");
        repository.save(lesson);

        lesson.setId(4L);
        lesson.setDeliveredOn(new Date());
        lesson.setTitle("Test Title 4");
        repository.save(lesson);

        lesson.setDeliveredOn(new Date());
        lesson.setTitle("I am you're mommy!");
        repository.save(lesson);

        MockHttpServletRequestBuilder request = patch("/lessons/" + 3L)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"id\": 3,\n" +
                        "    \"title\": \"Who is you're daddy?\",\n" +
                        "    \"deliveredOn\": \"2012-03-14\"\n" +
                        "}");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
        String actual = repository.findById(3L).get().getTitle();
        String expected = "Who is you're daddy?";
        assertEquals(expected, actual);
    }

    @Test
    @Transactional

    public void testGetLessonByTitle() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setId(1L);
        lesson.setDeliveredOn(new Date(2012-1-3));
        lesson.setTitle("Test Title");
        repository.save(lesson);

        lesson.setId(2L);
        lesson.setDeliveredOn(new Date(2015-2-4));
        lesson.setTitle("Test Title 2");
        repository.save(lesson);

        lesson.setId(3L);
        lesson.setDeliveredOn(new Date());
        lesson.setTitle("Test Title 3");
        repository.save(lesson);

        this.mvc.perform(get("/lessons/find/Test Title"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Test Title")));

    }

    @Test
    public void testGetLessonsByDateRange() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setId(1L);
        lesson.setDeliveredOn(new Date(112, 0, 4));
        lesson.setTitle("Test Title");
        repository.save(lesson);

        lesson.setId(2L);
        lesson.setDeliveredOn(new Date(114,2,3));
        lesson.setTitle("Test Title 2");
        repository.save(lesson);

        lesson.setId(3L);
        lesson.setDeliveredOn(new Date());
        lesson.setTitle("Test Title 3");
        repository.save(lesson);
        String testTitle = "Test Title";
        String date1 = "2014-01-01";
        String date2 = "2014-12-31";

        MockHttpServletRequestBuilder request = get("/lessons/between")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("startDate", date1)
                .param("endDate", date2);



        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(2)))
                .andExpect(jsonPath("$[0].title", is("Test Title 2")));

    }

}
