package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.authen.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IUserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);

}
