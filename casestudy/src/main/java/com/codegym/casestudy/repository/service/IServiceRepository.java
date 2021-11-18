package com.codegym.casestudy.repository.service;

import com.codegym.casestudy.model.service.Service;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service,Integer> {
    Page<Service> findAllByServiceNameContaining(Pageable pageable, String name);
}
