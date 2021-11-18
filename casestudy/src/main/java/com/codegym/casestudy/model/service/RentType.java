package com.codegym.casestudy.model.service;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentTypeId;

    private String rentTypeName;

    private Double rentTypeCost;

    @OneToMany(mappedBy = "rentType")
    private Set<Service> services;
}
