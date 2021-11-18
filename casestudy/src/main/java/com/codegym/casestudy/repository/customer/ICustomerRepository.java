package com.codegym.casestudy.repository.customer;

import com.codegym.casestudy.model.customer.Customer;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value ="select * from customer where customer.customer_name like %?1% and flag = false", nativeQuery = true)
    Page<Customer> findAllByCustomerNameContaining(Pageable pageable, String name);
}
