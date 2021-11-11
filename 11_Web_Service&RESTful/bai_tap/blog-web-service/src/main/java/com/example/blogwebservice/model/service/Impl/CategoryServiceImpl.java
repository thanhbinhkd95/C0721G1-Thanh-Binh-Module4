package com.example.blogwebservice.model.service.Impl;

import com.example.blogwebservice.model.entity.Category;
import com.example.blogwebservice.model.repository.ICategoryRepository;
import com.example.blogwebservice.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;
    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> finAll() {
        return categoryRepository.findAll();
    }
}
