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

import com.app.blog.model.Comment;
import com.app.blog.service.CommentService;

@RestController
public class CommentController {

	private static Logger _log = LoggerFactory.getLogger(CommentController.class);

	@Autowired
	private CommentService commentService;

	@GetMapping("/comments/{postId}")
	public ResponseEntity<List<Comment>> retrieveAllCommentsOfPost(@PathVariable long postId) {
		_log.info("retrieve all comments of post ...!");
		List<Comment> comments = commentService.getAllCommentsOfPost(postId);
		return new ResponseEntity<List<Comment>>(comments, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/comments")
	public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {

		_log.info("add comment controller...!");
		Comment savedComment = commentService.addComment(comment);
		return new ResponseEntity<Comment>(savedComment, new HttpHeaders(), HttpStatus.CREATED);
	}

	@DeleteMapping("/comments/{id}")
	public HttpStatus deleteComment(@PathVariable long id) throws Exception {

		_log.info("delete comment controller...!");
		commentService.deleteComment(id);
		return HttpStatus.ACCEPTED;
	}

	@PutMapping("/comments")
	public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {

		_log.info("update comment controller...!");
		Comment updatedComment = commentService.updateComment(comment);
		return new ResponseEntity<Comment>(updatedComment, new HttpHeaders(), HttpStatus.ACCEPTED);
	}
}
