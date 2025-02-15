package com.restart.accounts.service;

import com.restart.accounts.dto.AccountDto;
import com.restart.accounts.entity.AccountDetails;
import com.restart.accounts.entity.Accounts;
import com.restart.accounts.exception.ResourceNotFoundException;
import com.restart.accounts.repository.AccountsRepository;
import com.restart.accounts.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.restart.accounts.mapper.AccountsMapper.mapAccountsToAccountDto;

@Service
public class UpdateAccountService {

    private final AccountsRepository accountsRepository;

    private  final CustomerRepository customerRepository;
    @Autowired
    public UpdateAccountService(AccountsRepository accountsRepository, CustomerRepository customerRepository) {
        this.accountsRepository = accountsRepository;
        this.customerRepository = customerRepository;
    }


    public AccountDto UpdateAccounts(Long accountNumber, AccountDetails accountDetails){

        Optional<Accounts> optionalRequest = accountsRepository.findByAccountNumber(accountNumber);
        if(!optionalRequest.isPresent()){
            throw new ResourceNotFoundException("Customer details not found for account: ");
        }
        Accounts accounts = optionalRequest.get();

        // Update the fields with new data
        if (accountDetails.getAccountType() != null) {
            accounts.setAccountType(accountDetails.getAccountType());
        }
        if(accountDetails.getBranchAddress() != null) {
            accounts.setBranchAddress(accountDetails.getBranchAddress());
        }

        // Save the updated account in the database
        Accounts updatedAccount = accountsRepository.save(accounts);;
        return mapAccountsToAccountDto(updatedAccount);
    }



}

