package com.example.blogwebservice.model.repository;

import com.example.blogwebservice.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
