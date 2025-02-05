package com.restart.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MobileNumberAlreadyPresent extends RuntimeException{
    public MobileNumberAlreadyPresent(String e) {
        super(e);
    }
}
