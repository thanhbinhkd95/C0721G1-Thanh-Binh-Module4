package com.codegym.casestudy.service.service;

import com.codegym.casestudy.model.service.RentType;
import com.codegym.casestudy.model.service.Service;
import com.codegym.casestudy.model.service.ServiceType;
import org.springframework.data.domain.*;

import java.util.List;

public interface IServiceOfServive {

    List<Service> findAll();

    void save(Service service);

    Service findById(Integer id);

    void removeById(Integer id);

    Page<Service> searchByName(Pageable pageable, String name);

    List<ServiceType> findAllServiceType();

    List<RentType> findAllRentType();
}
