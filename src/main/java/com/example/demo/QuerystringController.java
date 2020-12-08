package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuerystringController {

    @GetMapping("/math/calculate")
    public String calcQuery (MathTest calculation) {
        return String.format("operation is %s; number1 is %s; number2 is %s; answer is %s", calculation.getOperation(), calculation.getNumber1(), calculation.getNumber2(), calculation.getAnswer() );

    }
}
