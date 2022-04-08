package com.example.demo.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    public void jacksonTest() {
        User user = new User("hello", 30);

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            String studentJson = objectMapper.writeValueAsString(user);

            System.out.println("studentJson = " + studentJson);
        }catch(IOException e){
            System.out.println("e = " + e);
        }
    }
}