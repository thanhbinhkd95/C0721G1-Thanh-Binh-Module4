package com.example.blogajax.model.service.Impl;

import com.example.blogajax.model.entity.Blog;
import com.example.blogajax.model.repository.IBlogRepository;
import com.example.blogajax.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAllByName(String name) {
        return blogRepository.findAllByName(name);
    }
}
