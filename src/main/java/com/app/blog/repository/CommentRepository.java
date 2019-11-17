package com.app.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.blog.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	public List<Comment> findByPostId(long postId);
	
	public void deleteByPostId(long postId);
}
