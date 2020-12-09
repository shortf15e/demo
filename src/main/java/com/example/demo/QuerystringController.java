package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;



@RestController
public class QuerystringController {

    @GetMapping("/math/calculate")
    public String calculate(@RequestParam(defaultValue = "add") String operation, @RequestParam int x, @RequestParam int y) {
        MathService result = new MathService();
        return result.calculate(operation, x, y);
    }

    @PostMapping("/math/sum")
    public String sum(@RequestParam Integer [] n) {
        MathService result = new MathService();
        return result.sum(n);

    }

    @RequestMapping("/math/volume/{l}/{w}/{h}")
    public String volumeCalculator(@PathVariable int l, @PathVariable int w, @PathVariable int h) {
        StringBuilder str = new StringBuilder();
        Integer answer = l*w*h;
        str.append("The volume of a " + l + "x" + w + "x" + h);
        str.append(" rectangle is " + answer);
        return str.toString();

    }

    @PostMapping(path = "/math/area", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String areaCalculator(@RequestBody Shape shape) {
        return shape.area();
    }



}

