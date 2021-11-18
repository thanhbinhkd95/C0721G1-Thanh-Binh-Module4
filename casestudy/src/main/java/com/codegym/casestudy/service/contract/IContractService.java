package com.codegym.casestudy.service.contract;

import com.codegym.casestudy.model.contract.Contract;
import org.springframework.data.domain.*;

import java.util.List;

public interface IContractService {

    List<Contract> findAll();

    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    Contract findById(Integer id);

    void removeById(Integer id);

    Page<Contract> findAllCustomerUseService(Pageable pageable, String name);
}
