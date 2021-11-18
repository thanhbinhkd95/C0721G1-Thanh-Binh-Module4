package com.codegym.casestudy.service.employee;

import com.codegym.casestudy.model.employee.Division;
import com.codegym.casestudy.model.employee.Education;
import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.model.employee.Position;
import org.springframework.data.domain.*;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(Integer id);

    void removeById(Integer id);

    Page<Employee> searchByName(Pageable pageable, String name);

    List<Position> findAllPossition();

    List<Division> findAllDivision();

    List<Education> findAllEducationDegree();
}
