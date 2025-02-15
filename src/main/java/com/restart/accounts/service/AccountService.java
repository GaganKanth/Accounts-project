package com.restart.accounts.service;

import com.restart.accounts.constants.AccountConstants;
import com.restart.accounts.dto.AccountDto;
import com.restart.accounts.dto.CustomerDto;
import com.restart.accounts.entity.Accounts;
import com.restart.accounts.entity.Customer;
import com.restart.accounts.exception.MobileNumberAlreadyPresent;
import com.restart.accounts.repository.AccountsRepository;
import com.restart.accounts.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

import static com.restart.accounts.mapper.AccountsMapper.mapAccountsToAccountDto;

@Service
@Slf4j
public class AccountService {

    private final AccountsRepository accountsRepository;

    private final CustomerRepository customerRepository;


    @Autowired
    public AccountService(AccountsRepository accountsRepository, CustomerRepository customerRepository) {
        this.accountsRepository = accountsRepository;
        this.customerRepository = customerRepository;
    }


    public AccountDto AccountDetails(CustomerDto customerDto) {
        // Check if mobile number already exists
        Optional<Customer> existingCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (existingCustomer.isPresent()) {
            throw new MobileNumberAlreadyPresent("Mobile number already exists in the DB");
        }

        // Create and save new customer
        Customer newCustomer = new Customer();
        newCustomer.setCustomerId(generateRandomCustomerId());
        newCustomer.setName(customerDto.getName());
        newCustomer.setEmail(customerDto.getEmail());
        newCustomer.setMobileNumber(customerDto.getMobileNumber());
        Customer savedCustomer = customerRepository.save(newCustomer);

        // Create and save new account
        Accounts newAccount = createNewAccount(savedCustomer);
        Accounts savedAccount = accountsRepository.save(newAccount);

        // Convert to DTO and return
        return mapAccountsToAccountDto(savedAccount);
    }



    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        customer.setCustomerId(generateRandomCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        return newAccount;
    }

    private long generateRandomCustomerId() {
        return 100000L + new Random().nextInt(900000);
    }


}

