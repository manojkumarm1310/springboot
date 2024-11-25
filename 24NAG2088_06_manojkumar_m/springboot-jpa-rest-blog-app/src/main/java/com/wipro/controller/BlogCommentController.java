package com.wipro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.model.BlogComment;
import com.wipro.service.BlogCommentService;

@RestController
public class BlogCommentController {

    @Autowired
    private BlogCommentService commentService;

    
    @PostMapping("/posts/{id}/comments")
    public ResponseEntity<String> addComment(@PathVariable Long id, @RequestBody String content) {
        return commentService.addComment(id, content);
    }

    
    @GetMapping("/posts/{id}/comments")
    public List<BlogComment> getComments(@PathVariable Long id) {
        return commentService.getComments(id);
    }
}
