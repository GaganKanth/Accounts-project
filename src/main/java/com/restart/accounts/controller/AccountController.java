package com.restart.accounts.controller;

import com.restart.accounts.constants.AccountConstants;
import com.restart.accounts.dto.AccountDto;
import com.restart.accounts.dto.CustomerDto;
import com.restart.accounts.dto.ErrorResponseDto;
import com.restart.accounts.dto.ResponseDto;
import com.restart.accounts.entity.AccountDetails;
import com.restart.accounts.service.AccountService;
import com.restart.accounts.service.UpdateAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/accounts-api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    private final AccountService accountService;

    private final UpdateAccountService updateAccountService;


    @Autowired
    public AccountController(AccountService accountService, UpdateAccountService updateAccountService) {
        this.accountService = accountService;
        this.updateAccountService = updateAccountService;

    }

    @Operation(
            summary = "Create Account REST API",
            description = "REST API to create new Customer &  Account inside EazyBank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )

    @PostMapping("/save")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        accountService.AccountDetails(customerDto);
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));


    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto>UpdateAccountDetails(@RequestParam Long AccountNumber,
                                                               @RequestBody AccountDetails accountDetails){

        updateAccountService.UpdateAccounts(AccountNumber,accountDetails);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }



}




