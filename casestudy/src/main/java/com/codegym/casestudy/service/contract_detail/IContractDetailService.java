package com.codegym.casestudy.service.contract_detail;

import com.codegym.casestudy.model.contract.AttachService;
import com.codegym.casestudy.model.contract.ContractDetail;
import org.springframework.data.domain.*;

import java.util.List;

public interface IContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);

    void save(ContractDetail contractDetail);

    ContractDetail findById(Integer id);

    void removeById(Integer id);

    List<AttachService> findAllAttachService();

    List<ContractDetail> findAllByContract_ContractId(Integer id);

    List<ContractDetail> findAllByContractDetailByAttachService();
}
