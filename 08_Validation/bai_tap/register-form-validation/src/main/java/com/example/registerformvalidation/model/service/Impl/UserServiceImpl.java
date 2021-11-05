package com.example.registerformvalidation.model.service.Impl;

import com.example.registerformvalidation.model.entity.User;
import com.example.registerformvalidation.model.repository.IUserRepository;
import com.example.registerformvalidation.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public List<User> fillAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
