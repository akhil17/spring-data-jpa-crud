package com.app.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.blog.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
