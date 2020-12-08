package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathTestTest {

    @Test
    public void testAdd() {
        MathTest add = new MathTest("add", 2, 3);
        int result = add.getAnswer();
        int expected = 5;
        assertEquals(expected, result);
    }
}
