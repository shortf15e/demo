package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(QuerystringController.class)

public class QuerystringControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testMathCalculateAdd() throws Exception {
        this.mvc.perform(get("/math/calculate/?operation=add&x=2&y=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2 + 3 = 5"));
    }

    @Test
    public void testMathCalculateSubtract() throws Exception {
        this.mvc.perform(get("/math/calculate/?operation=subtract&x=2&y=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2 - 3 = -1"));
    }
    @Test
    public void testMathCalculateMultiply() throws Exception {
        this.mvc.perform(get("/math/calculate/?operation=multiply&x=2&y=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2 * 3 = 6"));
    }

    @Test
    public void testMathCalculateDivide() throws Exception {
        this.mvc.perform(get("/math/calculate/?operation=divide&x=6&y=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("6 / 2 = 3"));
    }

    @Test
    public void testMathSum() throws Exception {
        this.mvc.perform(post("/math/sum/?n=4&n=5&n=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 5 + 6 = 15"));
    }

    @Test
    public void testVolumeGET() throws Exception {
        this.mvc.perform(get("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
    }

    @Test
    public void testVolumePOST() throws Exception {
        this.mvc.perform(post("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
    }

    @Test
    public void testVolumePATCH() throws Exception {
        this.mvc.perform(patch("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
    }

}
