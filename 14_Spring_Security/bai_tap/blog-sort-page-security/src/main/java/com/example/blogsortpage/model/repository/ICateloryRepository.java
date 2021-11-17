package com.example.blogsortpage.model.repository;

import com.example.blogsortpage.model.entity.Catelory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICateloryRepository extends JpaRepository<Catelory,Integer> {
}
