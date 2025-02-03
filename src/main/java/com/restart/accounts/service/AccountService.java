package com.restart.accounts.service;

import com.restart.accounts.dto.AccountDto;
import com.restart.accounts.entity.Accounts;
import com.restart.accounts.repository.AccountsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountService {

    private final AccountsRepository accountsRepository;

    @Autowired
    public AccountService(AccountsRepository accountsRepository){
        this.accountsRepository = accountsRepository;
    }

    public Accounts saveAccounts(AccountDto accountDto) {
        Accounts accounts = new Accounts();
        accounts.setAccountNumber(accountDto.getAccountNumber());
        accounts.setAccountType(accountDto.getAccountType());
        accounts.setBranchAddress(accountDto.getBranchAddress());
        return accountsRepository.save(accounts);
    }
}

