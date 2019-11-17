package com.app.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.blog.model.Comment;

@Repository
public interface CommentRepositiry extends JpaRepository<Comment, Long>{

}
