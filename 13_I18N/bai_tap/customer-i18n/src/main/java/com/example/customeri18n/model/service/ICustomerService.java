package com.example.customeri18n.model.service;

import com.example.customeri18n.model.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
}
