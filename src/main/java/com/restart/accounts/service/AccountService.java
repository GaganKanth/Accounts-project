package com.restart.accounts.service;

import com.restart.accounts.constants.AccountConstants;
import com.restart.accounts.dto.CustomerDto;
import com.restart.accounts.entity.Accounts;
import com.restart.accounts.entity.Customer;
import com.restart.accounts.mapper.CustomerMapper;
import com.restart.accounts.repository.AccountsRepository;
import com.restart.accounts.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class AccountService {

    private final AccountsRepository accountsRepository;

    private final CustomerRepository customerRepository;




    @Autowired
    public AccountService(AccountsRepository accountsRepository, CustomerRepository customerRepository){
        this.accountsRepository = accountsRepository;
        this.customerRepository = customerRepository;
    }


    public void AccountDetails(CustomerDto customerDto){

        Customer customer = CustomerMapper.mapCustomerDto(customerDto, new Customer());
        long randomCustomerId = 100000L + new Random().nextInt(900000);
        customer.setCustomerId(randomCustomerId);
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));

    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        return newAccount;
    }


}

