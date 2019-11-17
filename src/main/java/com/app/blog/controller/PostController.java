package com.app.blog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.blog.model.Post;
import com.app.blog.service.PostService;

@RestController
public class PostController {

	private static Logger _log = LoggerFactory.getLogger(PostController.class);

	@Autowired
	private PostService postService;

	@GetMapping("/posts")
	public ResponseEntity<List<Post>> retrieveAllPosts() {
		_log.info("retrieve all posts controller...!");
		List<Post> posts = postService.retrieveAllPosts();
		return new ResponseEntity<List<Post>>(posts, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> retrievePostById(@PathVariable long id) {

		_log.info("retrieve post controller...!");
		Post post = postService.getPost(id);
		return new ResponseEntity<Post>(post, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/posts")
	public ResponseEntity<Post> createPost(@RequestBody Post post) {

		_log.info("create post controller...!");
		Post savedPost = postService.createPost(post);
		return new ResponseEntity<Post>(savedPost, new HttpHeaders(), HttpStatus.CREATED);
	}

	@DeleteMapping("/posts/{id}")
	public HttpStatus deletePost(@PathVariable long id) throws Exception {

		_log.info("delete post controller...!");
		postService.deletePost(id);
		return HttpStatus.ACCEPTED;
	}

	@PutMapping("/posts")
	public ResponseEntity<Post> updatePost(@RequestBody Post post) {

		_log.info("update post controller...!");
		Post updatedPost = postService.updatePost(post);
		return new ResponseEntity<Post>(updatedPost, new HttpHeaders(), HttpStatus.ACCEPTED);
	}
}
