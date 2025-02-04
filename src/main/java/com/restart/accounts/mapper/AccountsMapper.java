package com.restart.accounts.mapper;

import com.restart.accounts.dto.AccountDto;
import com.restart.accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountDto mapAccountsToAccountDto ( Accounts accounts, AccountDto accountDto){
        accountDto.setAccountNumber(accounts.getAccountNumber());
        accountDto.setAccountType(accounts.getAccountType());
        accountDto.setBranchAddress(accounts.getBranchAddress());
        return accountDto;
    }

    public static Accounts mapAccountsDtoToAccounts(AccountDto accountDto, Accounts accounts){
    accounts.setAccountType(accountDto.getAccountType());
    accounts.setAccountNumber(accountDto.getAccountNumber());
    accounts.setBranchAddress(accountDto.getBranchAddress());
    return accounts;
    }
}
