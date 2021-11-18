package com.codegym.casestudy.repository.contract;

import com.codegym.casestudy.model.contract.Contract;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "select * from contract " +
            "join customer on customer.customer_id = contract.customer_id " +
            "where (current_date() between contract.contract_start_date " +
            "and contract.contract_end_date) and customer.customer_name like %?1%", nativeQuery = true)
    Page<Contract> findAllContractByCustomerUseService(Pageable pageable, String name);
}
