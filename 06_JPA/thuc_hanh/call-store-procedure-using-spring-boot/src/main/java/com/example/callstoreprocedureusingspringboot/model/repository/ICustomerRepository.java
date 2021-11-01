package com.example.callstoreprocedureusingspringboot.model.repository;

import com.example.callstoreprocedureusingspringboot.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
   // @Query(value = "CALL `customer_management`.Insert_Customer(:fistName,:lastName)",nativeQuery = true)
    @Procedure(procedureName = "Insert_Customer")
    void insertCallCustomer(String fist_name, String last_name);
}
