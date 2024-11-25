package com.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wipro.dto.TripFeedbackResponsedto;
import com.wipro.entity.TripFeedback;
@Service
public interface FeedbackServic {

	TripFeedback saveFeedback(Long bookingId,Long userId,TripFeedback feedback);

	Optional<TripFeedback> getFeedbackById(Long id);

	List<TripFeedback> getAllFeedback();

	void deleteFeedback(Long id);

	List<TripFeedbackResponsedto> getAllFeedbackTopRating();

}
