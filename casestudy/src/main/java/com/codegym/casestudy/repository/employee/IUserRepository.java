package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.authen.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
