package com.example.demo;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;



@RestController
public class QuerystringController {

    @GetMapping("/math/calculate")
    public String calculate(@RequestParam(defaultValue = "add") String operation, @RequestParam int x, @RequestParam int y) {
        MathTest result = new MathTest(operation, x, y);
        String print = Integer.toString(x).concat(" "+result.operator+" ").concat(Integer.toString(y)).concat(" = ").concat(Integer.toString(result.answer));
        return print;
    }

    @PostMapping("/math/sum")
    public String sum(@RequestParam Integer [] n) {
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

    @RequestMapping("/math/volume/{l}/{w}/{h}")
    public String volumeCalculator(@PathVariable int l, @PathVariable int w, @PathVariable int h) {
        StringBuilder str = new StringBuilder();
        Integer answer = l*w*h;
        str.append("The volume of a " + l + "x" + w + "x" + h);
        str.append(" rectangle is " + answer);
        return str.toString();

    }



}

