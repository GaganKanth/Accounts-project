package com.restart.accounts.service;

import com.restart.accounts.dto.AccountDto;
import com.restart.accounts.dto.CustomerDto;
import com.restart.accounts.entity.Accounts;
import com.restart.accounts.entity.Customer;
import com.restart.accounts.exception.AccountDetailsNotFoundException;
import com.restart.accounts.exception.CustomerNotFoundException;
import com.restart.accounts.repository.AccountsRepository;
import com.restart.accounts.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.restart.accounts.mapper.AccountsMapper.mapAccountsToAccountDto;
import static com.restart.accounts.mapper.CustomerMapper.mapCustomer;

@Service
public class DeleteAccountDetails {
    private final AccountsRepository accountsRepository;

    private  final CustomerRepository customerRepository;


    @Autowired
    public DeleteAccountDetails(AccountsRepository accountsRepository, CustomerRepository customerRepository) {
        this.accountsRepository = accountsRepository;
        this.customerRepository = customerRepository;
    }


    public AccountDto deleteAccountDetails(Long AccountNumber){
        Accounts accounts = accountsRepository.deleteByAccountNumber(AccountNumber).orElseThrow(() ->
                new AccountDetailsNotFoundException("Account not found with ID" + AccountNumber));
        return mapAccountsToAccountDto(accounts);
    }

    public CustomerDto deleteCustomerDetails(Long customerId){
        Customer customer=customerRepository.deleteByCustomerId(customerId).orElseThrow(()->
                new CustomerNotFoundException("Customer not found with id" + customerId));
        return mapCustomer(customer);

        }

    }

