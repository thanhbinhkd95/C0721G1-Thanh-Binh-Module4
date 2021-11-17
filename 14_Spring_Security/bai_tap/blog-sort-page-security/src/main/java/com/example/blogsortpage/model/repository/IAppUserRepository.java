package com.example.blogsortpage.model.repository;

import com.example.blogsortpage.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String userName);
}
