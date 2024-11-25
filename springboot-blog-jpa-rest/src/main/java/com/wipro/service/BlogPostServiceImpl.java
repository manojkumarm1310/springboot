package com.wipro.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.dao.BlogPostDAO;
import com.wipro.model.BlogPost;

@Service
public class BlogPostServiceImpl {

	@Autowired
	private BlogPostDAO blogPostDao;
	
	public ResponseEntity<BlogPost> addPost(BlogPost blogPost){
		
		if(blogPost.getTitle()==null || blogPost.getContent()==null) {
			return ResponseEntity.badRequest().build();
		}
		BlogPost addedBlog=blogPostDao.save(blogPost);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedBlog);
		
	}

	
	public ResponseEntity<List<BlogPost>> getAllPost() {
		// TODO Auto-generated method stub
		List<BlogPost> posts=blogPostDao.findAll();
		return posts.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(posts, HttpStatus.OK);
	}

	
	public ResponseEntity<BlogPost> getBlogPostById(Integer id){
		
			Optional<BlogPost> post = blogPostDao.findById(id);
			if(post.isPresent()) {
				return ResponseEntity.ok(post.get());
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		
	}
	

}
