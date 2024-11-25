package com.wipro.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.model.BlogPost;
import com.wipro.repository.BlogPostRepository;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository postRepository;

    
    public ResponseEntity<BlogPost> createPost(BlogPost post) {
       try {
    	   if (post.getTitle() == null || post.getContent() == null) {
               return ResponseEntity.badRequest().build();
           }
           BlogPost savedPost = postRepository.save(post);
           return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
       }catch(Exception e) {
    	   e.printStackTrace();
    	   throw e;
       }
    }

    
    public ResponseEntity<BlogPost> getPostById(Long id) {
        try {
        	Optional<BlogPost> post = postRepository.findById(id);
            if (post.isPresent()) {
                return ResponseEntity.ok(post.get());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch(Exception e) {
        	e.printStackTrace();
        	throw e;
        }
    }

    

    
}
