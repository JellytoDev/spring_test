package com.example.demo.controller;

import com.example.demo.exception.NoDeliveryException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exception")
public class ExceptionViewController {

    @ExceptionHandler(NoDeliveryException.class)
    public String noDelivery(NoDeliveryException e, Model model) {
        model.addAttribute("exception", e);
        return "deliver";
    }

    @GetMapping("/deliver")
    public String exceptionTest() {
        throw new NoDeliveryException("티켓 모두 소진됨");
    }

}
