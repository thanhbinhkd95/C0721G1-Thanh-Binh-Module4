package com.codegym.casestudy.model.employee;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int divisionId;
    private String divisionName;

    @OneToMany(mappedBy = "division")
    private Set<Employee> employees;

}
