package com.wipro.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dto.TripFeedbackResponsedto;
import com.wipro.entity.TripBooking;
import com.wipro.entity.TripFeedback;
import com.wipro.entity.Users;
import com.wipro.repository.TripBookingRepository;
import com.wipro.repository.TripFeedbackRepository;
import com.wipro.repository.UsersRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class FeedbackServiceImpl implements FeedbackServic{
	
	 	@Autowired
	    private TripFeedbackRepository tripFeedbackRepository;

	 	 @Autowired
	     private UsersRepository usersRepository;
	 	 
	 	 @Autowired
	 	 private TripBookingRepository tripBookingrepository;
	    @Override
	    public TripFeedback saveFeedback(Long bookingId,Long userId,TripFeedback feedback) {
	    	Users managedUser = usersRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("User not found"));
	    			feedback.setUser(managedUser);
	    			
	    	
	    	TripBooking managedBooking = tripBookingrepository.findById(bookingId)
	    	         .orElseThrow(() -> new EntityNotFoundException("Booking not found"));
	    	          feedback.setBooking(managedBooking);
	    
	    	feedback.setDateFeedback(LocalDate.now());
  
	    	return tripFeedbackRepository.save(feedback);
	    }


	    public Optional<TripFeedback> getFeedbackById(Long id) {
	        return tripFeedbackRepository.findById(id);
	    }

	    public List<TripFeedback> getAllFeedback() {
	        return tripFeedbackRepository.findAll();
	    }

	    public void deleteFeedback(Long id) {
	        tripFeedbackRepository.deleteById(id);
	    }


		@Override
		public List<TripFeedbackResponsedto> getAllFeedbackTopRating() {
			List<TripFeedback> list=this.getAllFeedback();
			List<TripFeedbackResponsedto> resList=new ArrayList<>();
			
			for(TripFeedback l:list) {
				TripFeedbackResponsedto res=new TripFeedbackResponsedto();
				if(l.getTripRating().intValue()>=4) {
					res.setUserName(l.getUser().getUsername());
					res.setPackageName(l.getBooking().getPackages().getPackageName());
					res.setFeedback(l.getTripFeedback());
					res.setRating(l.getTripRating());
					resList.add(res);
				}
			}
			return resList;
		}

}
