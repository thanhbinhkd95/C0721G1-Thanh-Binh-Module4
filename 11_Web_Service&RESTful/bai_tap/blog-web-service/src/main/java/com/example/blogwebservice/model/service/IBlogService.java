package com.example.blogwebservice.model.service;

import com.example.blogwebservice.model.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(int id);
}
