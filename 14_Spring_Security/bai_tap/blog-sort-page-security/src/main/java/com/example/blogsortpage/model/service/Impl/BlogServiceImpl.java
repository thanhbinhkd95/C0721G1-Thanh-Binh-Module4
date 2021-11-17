package com.example.blogsortpage.model.service.Impl;

import com.example.blogsortpage.model.entity.Blog;
import com.example.blogsortpage.model.repository.IBlogReporitory;
import com.example.blogsortpage.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogReporitory blogReporitory;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogReporitory.findAll(pageable);
    }

    @Override
    public Blog findById(Integer id) {
        return blogReporitory.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogReporitory.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogReporitory.save(blog);
    }

    @Override
    public void delete(Integer id) {
        blogReporitory.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByOrderByDateBlogAsc(Pageable pageable) {
        return blogReporitory.findAllByOrderByDateBlogAsc(pageable);
    }

    @Override
    public Page<Blog> findAllByNameBlogContaining(String searchName, Pageable pageable) {
        return blogReporitory.findAllByNameBlogContaining(searchName,pageable);
    }

//    @Override
//    public Page<Blog> findAllByCatelory_Id(Integer cateloryId, Pageable pageable) {
//        return blogReporitory.findAllByCatelory_Id(cateloryId, pageable);
//    }
}
