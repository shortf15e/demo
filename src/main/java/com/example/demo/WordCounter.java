package com.example.demo;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


@Component
public class WordCounter {


    public Map<String, Integer> count (String str) {
        Map<String, Integer> result = new HashMap<>();
        str = str.replaceAll("[,.?!:;]", "");
        String[] arrOfStr = str.split(" ", -2);

        for (String a : arrOfStr) {
            if (result.isEmpty()) {
                result.put(a, 1);
            } else if (result.containsKey(a)) {
                result.put(a, result.get(a) +1);
            } else {result.put(a,1);}
        }
        return result;

    }
}
