package com.example.blogsortpage.model.service;

import com.example.blogsortpage.model.entity.AppRole;

import java.util.List;

public interface IAppRoleService {
    List<AppRole> findAll();
    AppRole findById(Long id);
}
