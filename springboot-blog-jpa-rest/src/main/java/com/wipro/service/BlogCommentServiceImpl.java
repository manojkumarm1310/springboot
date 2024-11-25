package com.wipro.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.dao.BlogCommentDAO;
import com.wipro.dao.BlogPostDAO;
import com.wipro.model.BlogComment;
import com.wipro.model.BlogPost;

@Service
public class BlogCommentServiceImpl{

	@Autowired
	private BlogCommentDAO blogCommentDAO;
	
	@Autowired
	private BlogPostDAO blogPostDAO;
	
	
	public ResponseEntity<String> addComment(Integer id,String comment) {
			Optional<BlogPost> post = blogPostDAO.findById(id);
	        if (post.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
	        }

	        BlogComment blogComment=new BlogComment();
			blogComment.setBlogPost(post.get());
			blogComment.setComment(comment);
			blogComment.setCommentTime(LocalDateTime.now());
			blogCommentDAO.save(blogComment);
			return ResponseEntity.status(HttpStatus.CREATED).body("Comment added");
	}

	public List<BlogComment> getBlogCommentById(Integer id) {
			return blogCommentDAO.findByPostIdOrderByCreatedAtDesc(id);
		
	}

}
