package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
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

    @GetMapping("/valid/view")
    public String validView(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "valid";
    }

    @PostMapping("/valid/view")
    public String validPost(@Validated UserDto userDto, BindingResult bindingResult, Model model) {
        System.out.println("userDto.getName() = " + userDto.getName()+" "+bindingResult.hasErrors());

        if (bindingResult.hasErrors()) {
            System.out.println("bindingResult = " + bindingResult.getAllErrors());
            return "valid :: #form";
        }
        return "index";
    }
}
