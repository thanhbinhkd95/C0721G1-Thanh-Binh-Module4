package com.example.blogwebservice.model.service;

import com.example.blogwebservice.model.entity.Category;

import java.util.List;

public interface ICategoryService {
    Category findById(int id);
    List<Category> finAll();
}
