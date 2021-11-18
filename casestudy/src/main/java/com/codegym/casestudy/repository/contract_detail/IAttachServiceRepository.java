package com.codegym.casestudy.repository.contract_detail;

import com.codegym.casestudy.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachServiceRepository extends JpaRepository<AttachService,Integer> {
}
