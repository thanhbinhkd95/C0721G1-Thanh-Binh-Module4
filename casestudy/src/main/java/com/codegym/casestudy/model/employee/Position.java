package com.codegym.casestudy.model.employee;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int positionId;
    private String positionName;

    @OneToMany(mappedBy = "position" )
    private Set<Employee> employee;
}
