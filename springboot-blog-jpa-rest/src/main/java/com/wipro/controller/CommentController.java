package com.wipro.controller;

import java.time.LocalDateTime;
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


import com.wipro.model.BlogComment;
import com.wipro.service.BlogCommentServiceImpl;

@RestController
public class CommentController {
	@Autowired
	private BlogCommentServiceImpl blogCommentServiceImpl; 

	@PostMapping("posts/{id}/comments")
	public ResponseEntity<String> addComment(@PathVariable Integer id,@RequestBody String comment) {
			blogCommentServiceImpl.addComment(id,comment);
			return new ResponseEntity<>("added",HttpStatus.OK);
	} 
	@GetMapping("/comment/{id}")
	public ResponseEntity<List<BlogComment>> getBlogComments(@PathVariable Integer id){
		
			List<BlogComment> blogCommentList=blogCommentServiceImpl.getBlogCommentById(id);
			return new ResponseEntity<>(blogCommentList,HttpStatus.OK);
		
	}
	
}
