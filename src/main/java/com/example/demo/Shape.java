package com.example.demo;

public class Shape {
    String type;
    int radius = 0;
    int length = 0;
    int width = 0;

    public Shape(String type, int length, int width) {
        this.type = type;
        this.length = length;
        this.width = width;
        this.radius = radius;
    }

    public Shape(String type, int radius) {
        this.type= type;
        this.length = length;
        this.width = width;
        this.radius = radius;
    }

        public Shape() {
        this.type = "Nothing";
        this.length = length;
        this.width = width;
        this.radius = radius;
    }

    public void setType () {
        this.type = type;
    }

    public String getType () {
        return this.type;
    }

    public void setRadius () {
        this.radius = radius;
    }

    public int getRadius () {
        return this.radius;
    }

    public void setLength () {
        this.length = length;
    }

    public int getLength () {
        return this.length;
    }

    public void setWidth () {
        this.width = width;
    }

    public int getWidth () {
        return this.width;
    }






    public String area() {
        String result = "I can't find the area for that type of shape!";
        double area;

        if (this.type.equals("circle")) {
            area = Math.PI * radius * radius;
            return "Area of a circle with a radius of " + radius + " is " + String.format("%.5f", area);
        }
        if (this.type.equals("rectangle")) {
            area = length*width;
            return "Area of a " + length +"x" + width + " rectangle is " + String.format("%.0f", area);
        }
        return result;
    }
}
