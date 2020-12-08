package com.example.demo;

import java.util.Date;

public class MathTest {
    String operation;
    int number1;
    int number2;
    int answer;
    String operator;

    public MathTest(String operation, int x, int y) {
        this.operation = operation;
        this.number1 = x;
        this.number2 = y;
        this.setAnswer();
    }

    public String getOperation() {
        return this.operation;
    }


    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number) {
        this.number1 = number;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number) {
        this.number2 = number;
    }

    public void setAnswer() {
        switch (operation) {
            case "add":
                answer = number1 + number2;
                operator = "+";
                break;
            case "subtract":
                answer = number1 - number2;
                operator = "-";
                break;
            case "multiply":
                answer = number1*number2;
                operator = "*";
                break;
            case "divide":
                answer = number1/number2;
                operator = "/";
                break;
        }
    }

    public int getAnswer() {
        return answer;
    }

}
