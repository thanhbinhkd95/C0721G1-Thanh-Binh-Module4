package com.example.blogsortpage.model.repository;

import com.example.blogsortpage.model.entity.AppUser;
import com.example.blogsortpage.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleUserRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
