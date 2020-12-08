package com.example.demo;

import java.util.Date;

public class MathService {
    String operation;
    int number1;
    int number2;
    int answer;
    String operator;

    public MathService() {

    }

    public String calculate(String operation, int x, int y) {
        this.operation = operation;
        this.number1 = x;
        this.number2 = y;
        this.setAnswer();
        String result = x + " " + operator + " " + y + " = " + answer;
        return result;
    }

    public String sum(Integer [] n) {
        StringBuilder str = new StringBuilder();
        int sum = n[0];
        str.append(n[0]);
        for (int i = 1; i < n.length; i++) {
            sum += n[i];
            str.append(" + " + n[i]);
        }
        str.append(" = " + sum);
        return str.toString();
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
