package com.codegym.casestudy.service.customer;

import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.model.customer.CustomerType;
import org.springframework.data.domain.*;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Integer id);

    void removeById(Integer id);

    Page<Customer> searchByName(Pageable pageable, String name);

    List<CustomerType> findAllCustomerType();
}
