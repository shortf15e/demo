package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathTestTest {

    @Test
    public void testAdd() {
        MathService add = new MathService();
        String strresult = add.calculate("add", 2, 3);
        int result = add.getAnswer();
        int expected = 5;
        assertEquals(expected, result);
    }

//    @Test
//    public void testCircle () {
//        Shape circle = new Shape("circle", 4);
//        String result = circle.area();
//        String expected = "Area of a circle with a radius of 4 is 50.26548";
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testRectangle () {
//        Shape rectangle = new Shape("rectangle", 4, 7);
//        String result = rectangle.area();
//        String expected = "Area of a 4x7 rectangle is 28";
//        assertEquals(expected, result);
//    }
}
