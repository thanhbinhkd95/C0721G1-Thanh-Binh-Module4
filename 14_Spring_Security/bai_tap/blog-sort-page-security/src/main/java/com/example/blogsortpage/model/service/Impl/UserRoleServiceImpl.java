package com.example.blogsortpage.model.service.Impl;

import com.example.blogsortpage.model.entity.AppUser;
import com.example.blogsortpage.model.entity.UserRole;
import com.example.blogsortpage.model.repository.IAppRoleRepository;
import com.example.blogsortpage.model.repository.IRoleUserRepository;
import com.example.blogsortpage.model.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements IUserRoleService {
    @Autowired
    IRoleUserRepository userRoleRepository;
    @Autowired
    IAppRoleRepository appRoleRepository;
    @Override
    public void save(AppUser appUser, Long id) {
        this.userRoleRepository.save(new UserRole(appUser,this.appRoleRepository.findById(id).orElse(null)));
    }
}
