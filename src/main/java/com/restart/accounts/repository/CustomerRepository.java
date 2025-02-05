package com.restart.accounts.repository;

import com.restart.accounts.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,Long> {
    Optional<Customer> findByMobileNumber(Long MobileNumber);
}
