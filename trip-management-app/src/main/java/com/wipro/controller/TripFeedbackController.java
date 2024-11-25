package com.wipro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.TripFeedbackResponsedto;
import com.wipro.entity.TripFeedback;
import com.wipro.service.FeedbackServic;

@RestController
@RequestMapping("/api")
public class TripFeedbackController {

    @Autowired
    private FeedbackServic tripFeedbackService;


    @PostMapping("/booking/{bookingId}/feedback/{userId}")
    public ResponseEntity<TripFeedback> createOrUpdateFeedback(@PathVariable(value="bookingId")Long bookingId,@PathVariable(value="userId")Long userId, @RequestBody TripFeedback feedback) {
    	System.out.println(feedback);
        TripFeedback savedFeedback = tripFeedbackService.saveFeedback(bookingId,userId,feedback);
        return new ResponseEntity<>(savedFeedback, HttpStatus.CREATED);
    }

    @GetMapping("/booking/feedback/{id}")
    public ResponseEntity<TripFeedback> getFeedbackById(@PathVariable Long id) {
        Optional<TripFeedback> feedback = tripFeedbackService.getFeedbackById(id);
        return feedback.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

  
    @GetMapping("/adminuser/booking/feedback")
    public ResponseEntity<List<TripFeedback>> getAllFeedback() {
        List<TripFeedback> feedbackList = tripFeedbackService.getAllFeedback();
        return new ResponseEntity<>(feedbackList, HttpStatus.OK);
    }

    @GetMapping("/adminuser/getAllfeedback")
    public List<TripFeedbackResponsedto> getAllFeedbackTopRating(){
    	return tripFeedbackService.getAllFeedbackTopRating();
    }
    

}
