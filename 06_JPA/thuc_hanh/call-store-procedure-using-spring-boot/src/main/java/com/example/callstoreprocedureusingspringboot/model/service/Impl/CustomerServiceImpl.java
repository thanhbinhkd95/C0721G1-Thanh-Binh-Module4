package com.example.callstoreprocedureusingspringboot.model.service.Impl;

import com.example.callstoreprocedureusingspringboot.model.entity.Customer;
import com.example.callstoreprocedureusingspringboot.model.repository.ICustomerRepository;
import com.example.callstoreprocedureusingspringboot.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;
    @Override
    public void insertCustomer(Customer customer) {
        customerRepository.insertCallCustomer(customer.getFirstName(),customer.getLastName());
    }
}
