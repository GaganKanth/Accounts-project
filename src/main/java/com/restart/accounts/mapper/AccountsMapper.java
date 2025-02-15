package com.restart.accounts.mapper;

import com.restart.accounts.dto.AccountDto;
import com.restart.accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountDto mapAccountsToAccountDto(Accounts accounts) {

        AccountDto dto = new AccountDto();
        dto.setAccountNumber(accounts.getAccountNumber());
        dto.setAccountType(accounts.getAccountType());
        dto.setBranchAddress(accounts.getBranchAddress());
        return dto;
    }

    public static Accounts mapAccountsDtoToAccounts(AccountDto accountDto) {
        Accounts accounts = new Accounts();
        accounts.setAccountType(accountDto.getAccountType());
        accounts.setAccountNumber(accountDto.getAccountNumber());
        accounts.setBranchAddress(accountDto.getBranchAddress());
        return accounts;
    }
}
