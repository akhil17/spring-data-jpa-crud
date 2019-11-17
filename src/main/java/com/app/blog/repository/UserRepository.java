package com.app.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blog.model.User;

public interface UserRepository extends JpaRepository<User, String>{

}
