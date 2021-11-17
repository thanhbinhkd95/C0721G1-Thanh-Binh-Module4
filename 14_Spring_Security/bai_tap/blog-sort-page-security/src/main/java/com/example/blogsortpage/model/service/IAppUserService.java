package com.example.blogsortpage.model.service;

import com.example.blogsortpage.model.entity.AppUser;

import java.util.List;

public interface IAppUserService {
    AppUser findByUserName(String userName);
    void save(AppUser appUser);
    List<AppUser> findAll();
}
