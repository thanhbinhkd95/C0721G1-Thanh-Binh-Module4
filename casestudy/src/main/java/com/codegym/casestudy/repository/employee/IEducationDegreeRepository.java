package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.employee.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationDegreeRepository extends JpaRepository<Education,Integer> {

}
