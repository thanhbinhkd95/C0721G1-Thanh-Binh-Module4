package com.example.blogsortpage.model.service;

import com.example.blogsortpage.model.entity.Blog;
import com.example.blogsortpage.model.entity.Catelory;

import java.util.List;

public interface ICateloryService {
    List<Catelory> findAll();
    Catelory findById(Integer id);
    void save(Catelory catelory);
    void update(Catelory catelory);
    void delete(Integer id);
}
