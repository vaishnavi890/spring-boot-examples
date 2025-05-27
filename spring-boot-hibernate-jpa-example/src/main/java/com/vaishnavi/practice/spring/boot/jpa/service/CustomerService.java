package com.vaishnavi.practice.spring.boot.jpa.service;

import com.vaishnavi.practice.spring.boot.jpa.model.CustomerModel;

import java.util.List;

public interface CustomerService {

    CustomerModel saveCustomer(CustomerModel customer);
    boolean deleteCustomer(final Long customerId);
    List<CustomerModel> getAllCustomers();
    CustomerModel getCustomerById(final Long customerId);
}

