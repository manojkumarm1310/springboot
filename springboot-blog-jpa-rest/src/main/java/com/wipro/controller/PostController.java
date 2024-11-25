package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wipro.model.BlogPost;
import com.wipro.service.BlogPostServiceImpl;


@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired 
	private BlogPostServiceImpl blogPostServiceImpl;
	
	@GetMapping("/{id}")
	public ResponseEntity<BlogPost> getById(@PathVariable(name="id") Integer id) {
	
			return blogPostServiceImpl.getBlogPostById(id);

	}
	
	@PostMapping
	public ResponseEntity<BlogPost> addPost(@RequestBody BlogPost post) {
		
			return blogPostServiceImpl.addPost(post);
		
	}

	@GetMapping("/getAllPost")
	public ResponseEntity<List<BlogPost>> getPostById() {
		
			return blogPostServiceImpl.getAllPost();
		
	}

}
