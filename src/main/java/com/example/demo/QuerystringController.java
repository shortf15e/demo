package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuerystringController {

    @GetMapping("/math/calculate")
    public String calculate(@RequestParam(defaultValue = "add") String operation, @RequestParam int x, @RequestParam int y) {
        MathTest result = new MathTest(operation, x, y);
        String print = Integer.toString(x).concat(" "+result.operator+" ").concat(Integer.toString(y)).concat(" = ").concat(Integer.toString(result.answer));
        return print;
    }

    @PostMapping("/math/num")
    public String sum(@RequestParam Integer [] n) {
        StringBuilder str = new StringBuilder();
        int sum = 0;
        for (x : n) {
            
        }
    }

}

