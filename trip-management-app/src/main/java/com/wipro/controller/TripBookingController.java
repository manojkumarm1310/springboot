package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.wipro.repository.UsersRepository;
import com.wipro.service.TripBookingService;
import com.wipro.service.UsersService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TripBookingController {
	
	@Autowired
	private TripBookingService tripBookingService;
	
	@PostMapping("/booking/package/{packageId}/user/{userId}/book")
	public TripBooking bookTrip(@PathVariable(value="packageId")Long packageId,@PathVariable(value="userId")Long userId,@RequestBody BookingDto bookingdto) throws UserException {
		return tripBookingService.bookTrip(packageId,userId,bookingdto);
	}
	
	@GetMapping("/booking/getAllBookings")
	public List<TripBooking> getAllBooking(){
		return tripBookingService.getAllBooking();
	}
	
	@GetMapping("/booking/getBookingById/{bookingId}")
	public TripBooking getBookingById(@PathVariable(value="bookingId")Long bookingId) {
		return tripBookingService.getBookingById(bookingId);
	}
	
	@GetMapping("/getAllPackages/booking/{userId}")
	public List<TripBooking> getAllPackagesForOneUser(@PathVariable(value="userId")Long userId){
		return tripBookingService.getAllPackagesForOneUser(userId);
	}
	
	
	
	
}
