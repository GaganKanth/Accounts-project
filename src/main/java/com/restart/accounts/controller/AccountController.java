package com.restart.accounts.controller;

import com.restart.accounts.dto.AccountDto;
import com.restart.accounts.entity.Accounts;
import com.restart.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/accounts-api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/save")
    public ResponseEntity<Accounts> createAccount(@RequestBody AccountDto accountDto) {
        Accounts savedAccounts = accountService.saveAccounts(accountDto);
        return new ResponseEntity<>(savedAccounts, HttpStatus.CREATED);
    }
}




