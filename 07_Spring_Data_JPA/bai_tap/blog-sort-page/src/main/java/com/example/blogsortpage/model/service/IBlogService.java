package com.example.blogsortpage.model.service;

import com.example.blogsortpage.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    Blog findById(Integer id);
    void save(Blog blog);
    void update(Blog blog);
    void delete(Integer id);
    Page<Blog> findAllByOrderByDateBlogAsc(Pageable pageable);
    Page<Blog> findAllByNameBlogContaining(String searchName,Pageable pageable);
//    Page<Blog> findAllByCatelory_Id(Integer cateloryId, Pageable pageable);
}
