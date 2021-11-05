package com.example.registerformvalidation.model.service;

import com.example.registerformvalidation.model.entity.User;

import java.util.List;

public interface IUserService {
    List<User> fillAll();
    void save(User user);
}
