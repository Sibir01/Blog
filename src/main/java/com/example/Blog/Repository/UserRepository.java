package com.example.Blog.Repository;

import com.example.Blog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByLogin(String login);

}
