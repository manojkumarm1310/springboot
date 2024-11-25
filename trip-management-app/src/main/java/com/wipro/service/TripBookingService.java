package com.wipro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.dto.BookingDto;
import com.wipro.entity.TripBooking;
import com.wipro.exception.UserException;

@Service
public interface TripBookingService {

//	TripBooking bookTrip(BookingDto bookingdto) throws UserException;

	List<TripBooking> getAllBooking();

	TripBooking getBookingById(Long bookingId);

	

	TripBooking bookTrip(Long packageId, Long userId, BookingDto bookingdto) throws UserException;

	List<TripBooking> getAllPackagesForOneUser(Long userId);

}
