package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.authen.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    List<User> findByUsernameContaining(String username);

}
