package com.app.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blog.model.Comment;

public interface CommentRepositiry extends JpaRepository<Comment, Long>{

}
