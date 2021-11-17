package com.example.blogsortpage.model.service.Impl;

import com.example.blogsortpage.model.entity.AppRole;
import com.example.blogsortpage.model.repository.IAppRoleRepository;
import com.example.blogsortpage.model.service.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppRoleServiceImpl implements IAppRoleService {
    @Autowired
    private IAppRoleRepository appRoleRepository;
    @Override
    public List<AppRole> findAll() {
        return appRoleRepository.findAll();
    }

    @Override
    public AppRole findById(Long id) {
        return appRoleRepository.findById(id).orElse(null);
    }
}
