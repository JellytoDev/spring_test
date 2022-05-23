package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class TestController {
    @GetMapping("/")
    public String index(Model model) {
        HashMap<Object, Object> first = new HashMap<>();
        HashMap<Object, Object> second = new HashMap<>();
        HashMap<Object, Object> third = new HashMap<>();
        HashMap<Object, Object> last = new HashMap<>();

        first.put("data", 1234);
        first.put("second", second);

        second.put("data", 5678);
        second.put("third", third);

        third.put("data", 91011);
        third.put("last", last);


        model.addAttribute("first", first);

        return "index";
    }

    @GetMapping("/global")
    public String global(Model model) {
        return "global";
    }
}
