package com.wipro.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.model.BlogComment;
import com.wipro.model.BlogPost;
import com.wipro.repository.BlogCommentRepository;
import com.wipro.repository.BlogPostRepository;

@Service
public class BlogCommentService {

	 	@Autowired
	    private BlogCommentRepository commentRepository;

	    @Autowired
	    private BlogPostRepository postRepository;

	    
	    public ResponseEntity<String> addComment(Long id, String content) {
	        try {
	        	Optional<BlogPost> post = postRepository.findById(id);
		        if (post.isEmpty()) {
		            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
		        }

		        BlogComment comment = new BlogComment();
		        comment.setPost(post.get());
		        comment.setContent(content);
		        comment.setCreatedAt(LocalDateTime.now());
		        commentRepository.save(comment);

		        return ResponseEntity.status(HttpStatus.CREATED).body("Comment created");
	        }catch(Exception e) {
	        	e.printStackTrace();
	        	throw e;
	        }
	    }

	    
	    public List<BlogComment> getComments(Long id) {
	    	try {
	    		return commentRepository.findByPostIdOrderByCreatedAtDesc(id);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    		throw e;
	    	}
	    }
}
