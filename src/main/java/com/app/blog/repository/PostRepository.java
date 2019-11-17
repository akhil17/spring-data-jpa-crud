package com.app.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.blog.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	
}
