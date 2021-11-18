package com.codegym.casestudy.model.customer;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerTypeId;
    private String customerTypeName;
    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customers;
}
