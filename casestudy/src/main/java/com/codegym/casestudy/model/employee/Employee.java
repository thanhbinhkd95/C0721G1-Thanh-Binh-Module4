package com.codegym.casestudy.model.employee;

import com.codegym.casestudy.model.authen.User;
import com.codegym.casestudy.model.contract.Contract;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String employeeName;
    private Date employeeBirthday;
    private String employeeIdCard;
    private double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contract;

    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "position_id" ,referencedColumnName = "positionId")
    private Position position;

    @ManyToOne(targetEntity = Education.class)
    @JoinColumn( name = "education_degree_id",referencedColumnName = "educationDegreeId")
    private Education education;

    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "division_id",referencedColumnName = "divisionId")
    private Division division;

    @OneToOne (cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;
}
