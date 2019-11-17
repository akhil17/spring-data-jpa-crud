package com.app.blog.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.blog.model.Post;
import com.app.blog.repository.PostRepository;
import com.app.blog.service.PostService;

@RestController
public class PostController {

	private static Logger _log = LoggerFactory.getLogger(PostController.class); 
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/posts")
	public List<Post> retrieveAllPosts() {
		_log.info("retrieve all posts controller...!");
		return postService.retrieveAllPosts();
	}
	
	@GetMapping("/posts/{id}")
	public Post retrievePost(@PathVariable long id) {
		
		return postService.getPost(id);
	}
	
	@PostMapping("/posts")
	public Post createPost(@RequestBody Post post) {
		
		_log.info("create post controller...!");
		return postService.createPost(post);
	}
}
