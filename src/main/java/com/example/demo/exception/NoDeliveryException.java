package com.example.demo.exception;

import org.springframework.dao.DataAccessException;

public class NoDeliveryException extends DataAccessException {

    public NoDeliveryException(String msg) {
        super(msg);
    }
    public NoDeliveryException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
