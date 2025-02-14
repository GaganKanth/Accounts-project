package com.restart.accounts.repository;

import com.restart.accounts.entity.Accounts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends MongoRepository<Accounts,Long> {

    Optional<Accounts> findByAccountNumber(Long AccountNumber);

   Optional<Accounts>deleteByAccountNumber(Long AccountNumber);

}
