package com.codegym.casestudy.model.service;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceTypeId;
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType")
    private Set<Service> services;
}
