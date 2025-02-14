package com.restart.accounts.service;

import com.restart.accounts.entity.Accounts;
import com.restart.accounts.entity.Customer;
import com.restart.accounts.exception.AccountDetailsNotFoundException;
import com.restart.accounts.exception.CustomerNotFoundException;
import com.restart.accounts.repository.AccountsRepository;
import com.restart.accounts.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAccountService {
    private final CustomerRepository customerRepository;
    private final AccountsRepository accountsRepository;

    @Autowired
    public GetAccountService(CustomerRepository customerRepository, AccountsRepository accountsRepository) {
        this.customerRepository = customerRepository;
        this.accountsRepository = accountsRepository;
    }


    public Customer getCustomerDetails(Long customerId){
        return customerRepository.findByCustomerId(customerId).orElseThrow(() ->
                new CustomerNotFoundException("Customer not found with ID: " + customerId));

    }

    public Accounts getAccountDetails(Long accountNumber){
        return accountsRepository.findByAccountNumber(accountNumber).orElseThrow(()->
                new AccountDetailsNotFoundException("Account not found with ID" + accountNumber));
    }
}
