package com.restart.accounts.mapper;

import com.restart.accounts.dto.CustomerDto;
import com.restart.accounts.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapCustomer(Customer customer, CustomerDto customerDto){
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customerDto.getMobileNumber());
        return customerDto;
    }

    public static Customer mapCustomerDto(CustomerDto customerDto, Customer customer){
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return  customer;
    }

}
