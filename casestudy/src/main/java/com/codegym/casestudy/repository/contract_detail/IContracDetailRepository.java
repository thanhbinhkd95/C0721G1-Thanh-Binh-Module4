package com.codegym.casestudy.repository.contract_detail;

import com.codegym.casestudy.dto.contract_dto.ContractDetailDto;
import com.codegym.casestudy.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContracDetailRepository extends JpaRepository<ContractDetail,Integer> {

    List<ContractDetail> findAllByContract_ContractId(Integer id);
    @Query(value = " select contract_detail.contract_detail_id as contractDetailId, sum(contract_detail.quantity) as quantity , contract_detail.attach_service_id as attachServiceId ," +
            " contract_detail.contract_id as contractId , attach_service.attach_service_name as attachServiceName " +
            " from contract_detail " +
            " join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id " +
            "group by contract_detail.attach_service_id,contract_detail.contract_id ",nativeQuery = true)
    List<ContractDetail> findAllByContractDetailOther();
}
