package com.codegym.casestudy.service.user;

import com.codegym.casestudy.model.authen.User;

import java.util.List;

public interface IUserService {
    void save(User user);
    User findByUserName(String username);
    User findById(Integer id);

    void update(User user);

    List<User> searchByUserName(String usename);

}
