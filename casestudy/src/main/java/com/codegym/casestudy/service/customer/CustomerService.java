package com.codegym.casestudy.service.customer;

import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.model.customer.CustomerType;
import com.codegym.casestudy.repository.contract.ICustomerTypeRepository;
import com.codegym.casestudy.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Autowired
    ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);

    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id).get();
    }

    @Override
    public void removeById(Integer id) {
        iCustomerRepository.deleteById(id);


    }

    @Override
    public Page<Customer> searchByName(Pageable pageable, String name) {
        return iCustomerRepository.findAllByCustomerNameContaining(pageable, name);
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        return iCustomerTypeRepository.findAll();
    }
}
