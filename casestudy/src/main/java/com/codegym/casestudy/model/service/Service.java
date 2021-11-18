package com.codegym.casestudy.model.service;

import com.codegym.casestudy.model.contract.Contract;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;
    private String serviceName;
    private int serviceArea;
    private double serviceCost;
    private int serviceMaxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private int poolArea;
    private int numberOfFloors;

    @ManyToOne(targetEntity = ServiceType.class)
    @JoinColumn(name = "service_type_id", referencedColumnName = "serviceTypeId")
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service")
    private Set<Contract> contract;

    @ManyToOne(targetEntity = RentType.class)
    @JoinColumn(name = "rent_type_id", referencedColumnName = "rentTypeId")
    private RentType rentType;
}
