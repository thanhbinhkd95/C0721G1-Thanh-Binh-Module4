package com.example.blogwebservice.model.service.Impl;

import com.example.blogwebservice.model.entity.Blog;
import com.example.blogwebservice.model.repository.IBlogRepository;
import com.example.blogwebservice.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }
}
