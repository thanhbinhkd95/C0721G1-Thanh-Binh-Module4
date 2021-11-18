package com.codegym.casestudy.service.service;

import com.codegym.casestudy.model.service.RentType;
import com.codegym.casestudy.model.service.Service;
import com.codegym.casestudy.model.service.ServiceType;
import com.codegym.casestudy.repository.service.IRentTypeRepossitory;
import com.codegym.casestudy.repository.service.IServiceRepository;
import com.codegym.casestudy.repository.service.IServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceOfService implements IServiceOfServive {
    @Autowired
    IServiceRepository iServiceRepository;
    @Autowired
    IRentTypeRepossitory iRentTypeRepossitory;
    @Autowired
    IServiceTypeRepository iServiceTypeRepository;

    @Override
    public List<Service> findAll() {
        return iServiceRepository.findAll();
    }

    @Override
    public void save(Service service) {
        iServiceRepository.save(service);

    }

    @Override
    public Service findById(Integer id) {
        return iServiceRepository.findById(id).get();
    }

    @Override
    public void removeById(Integer id) {
        iServiceRepository.deleteById(id);

    }

    @Override
    public Page<Service> searchByName(Pageable pageable, String name) {
        return iServiceRepository.findAllByServiceNameContaining(pageable, name);
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        return iServiceTypeRepository.findAll();
    }

    @Override
    public List<RentType> findAllRentType() {
        return iRentTypeRepossitory.findAll();
    }
}
