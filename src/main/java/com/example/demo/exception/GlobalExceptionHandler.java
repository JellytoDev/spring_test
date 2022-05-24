package com.example.demo.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //이 DispatcherServlet에서 실행(doDispatch)을 하다가 에러가 발생하면(exception != null) 
    //@ControllerAdvice로 정의된 빈이 주입된 handlerExceptionResolvers가 실행되는 구조입니다.

    @ExceptionHandler(java.lang.IllegalArgumentException.class)
    public ResponseEntity IllegalArgumentException(IllegalArgumentException illegalArgumentException) {
        return new ResponseEntity(HttpStatus.OK);
    }

}

