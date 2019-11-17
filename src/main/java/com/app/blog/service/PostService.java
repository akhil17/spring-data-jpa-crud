package com.app.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.blog.model.Post;
import com.app.blog.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public List<Post> retrieveAllPosts() {
		return postRepository.findAll();
	}
	
	public Post getPost(long id) {
		return postRepository.getOne(id);
	}
	
	public Post createPost(Post post) {
		return postRepository.save(post);
	}
}
