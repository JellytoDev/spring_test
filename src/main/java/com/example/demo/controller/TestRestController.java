package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @PostMapping(value="/valid", produces = "application/json",consumes = "application/json")
    @ResponseBody
    public String validationTest(@Validated @RequestBody UserDto userDto, BindingResult bindingResult) {
        System.out.println("userDto = " + userDto.getName());
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldErrors().toString();
        }else{
            return "유효성 검증에서 통과하였습니다";
        }
    }
}
