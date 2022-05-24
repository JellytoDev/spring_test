package com.example.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
public class ExceptionTestController {

    @ExceptionHandler
    public Object handlerException(Exception e) {
        System.out.println("ExceptionTestController.handlerException");
        return "error";
    }

    // HandlerExceptionResolver에 의해 등록한 형태로 매핑하여 처리
    @ExceptionHandler(value = {IOException.class, FileNotFoundException.class})
    public Object notFoundHandler(Exception e) {
        return "notfound";
    }

    @ExceptionHandler(value = TimeoutException.class)
    public Object timeoutExceptionHandler(Exception e) {
        System.out.println("ExceptionTestController.timeoutExceptionHandler");
        return "error";
    }


}
