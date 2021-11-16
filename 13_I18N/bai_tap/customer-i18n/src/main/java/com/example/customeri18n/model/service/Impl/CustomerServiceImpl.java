package com.example.customeri18n.model.service.Impl;

import com.example.customeri18n.model.entity.Customer;
import com.example.customeri18n.model.repository.ICustomerRepository;
import com.example.customeri18n.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
            customerRepository.save(customer);
    }
}
