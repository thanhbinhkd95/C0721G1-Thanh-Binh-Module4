package com.example.blogsortpage.model.service.Impl;

import com.example.blogsortpage.model.entity.AppUser;
import com.example.blogsortpage.model.repository.IAppUserRepository;
import com.example.blogsortpage.model.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppUserServiceImpl implements IAppUserService {
    @Autowired
    private IAppUserRepository appUserRepository;
    @Override
    public AppUser findByUserName(String userName) {
        return appUserRepository.findByUserName(userName);
    }

    @Override
    public void save(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }
}
