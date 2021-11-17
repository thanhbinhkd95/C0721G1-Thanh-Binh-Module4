package com.example.blogsortpage.model.repository;

import com.example.blogsortpage.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IBlogReporitory extends JpaRepository<Blog, Integer> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByOrderByDateBlogAsc(Pageable pageable);
    @Query(value = "select b from Blog b where b.name like %?1% order by b.dateBlog ASC ",nativeQuery = false)
    Page<Blog> findAllByNameBlogContaining(String name,Pageable pageable);
//    Page<Blog> findAllByCateloryBlog_ID(Integer cateloryId, Pageable pageable);

}
