package com.codegym.casestudy.model.customer;

import com.codegym.casestudy.model.contract.Contract;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String customerName;
    private String customerEmail;
    private String codeCustomer;
    @Column(name = "customer_birthday")
    private Date customerBirthDay;
    private int customerGender;
    private String customerIdCard;
    private String customerPhone;
    @Column(name = "customer_adress")
    private String customerAddress;

    @OneToMany(mappedBy = "customer")
    private List<Contract> contract;



    @ManyToOne(targetEntity = CustomerType.class)
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customerTypeId")
    private CustomerType customerType;


    private boolean flag;
}
