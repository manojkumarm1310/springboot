package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.model.BlogPost;
import com.wipro.service.BlogPostService;

@RestController
public class BlogPostController {

	@Autowired
	private BlogPostService postService;

	@PostMapping("/posts")
	public ResponseEntity<BlogPost> createPost(@RequestBody BlogPost post) {
		return postService.createPost(post);
	}

	@GetMapping("/posts/{id}")
	public ResponseEntity<BlogPost> getPostById(@PathVariable Long id) {
		return postService.getPostById(id);
	}

}
