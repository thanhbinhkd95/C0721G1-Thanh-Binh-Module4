package com.codegym.casestudy.repository.service;

import com.codegym.casestudy.model.service.Service;
import com.codegym.casestudy.model.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}
