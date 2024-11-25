package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.BookingDto;
import com.wipro.entity.TripBooking;
import com.wipro.exception.UserException;
import com.wipro.service.TripBookingService;

@RestController
@RequestMapping("/user")
public class TripBookingController {
	
	@Autowired
	private TripBookingService tripBookingService;
	
	
	@PostMapping("/booking/book")
	public TripBooking bookTrip(@RequestBody BookingDto bookingdto) throws UserException {
		return tripBookingService.bookTrip(bookingdto);
	}
	
	@GetMapping("/booking/getAllBookings")
	public List<TripBooking> getAllBooking(){
		return tripBookingService.getAllBooking();
	}
	
	@GetMapping("/booking/getBookingById/{bookingId}")
	public TripBooking getBookingById(@PathVariable(value="bookingId")Long bookingId) {
		return tripBookingService.getBookingById(bookingId);
	}
	
	@PutMapping("/booking/cancelbooking/{bookingId}")
	public TripBooking cancelBooking(@PathVariable(value="bookingId")Long bookingId) {
		return tripBookingService.cancelBooking(bookingId);
	}
}
