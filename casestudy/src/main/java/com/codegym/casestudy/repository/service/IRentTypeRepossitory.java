package com.codegym.casestudy.repository.service;

import com.codegym.casestudy.model.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepossitory extends JpaRepository<RentType,Integer> {
}
