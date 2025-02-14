package com.restart.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountDetailsNotFoundException extends RuntimeException{

    public AccountDetailsNotFoundException(String e){
        super(e);
    }
}
