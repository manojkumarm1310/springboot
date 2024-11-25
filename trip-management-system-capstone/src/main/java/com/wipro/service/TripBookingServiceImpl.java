
package com.wipro.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dto.BookingDto;
import com.wipro.entity.TripBooking;
import com.wipro.entity.TripBus;
import com.wipro.entity.TripPackage;
import com.wipro.entity.Users;
import com.wipro.exception.UserException;
import com.wipro.repository.TripBookingRepository;

@Service
public class TripBookingServiceImpl implements TripBookingService{

	@Autowired
	private TripPackageService tripPackageService;
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private TripBusService tripBusService;
	
	@Autowired
	private TripBookingRepository tripBookingRepository;
	@Override
	public TripBooking bookTrip(BookingDto bookingdto) throws UserException {
		TripBooking booking =new TripBooking();
		TripPackage tripPackage=tripPackageService.getPackageById(bookingdto.getPackageId());
		Users user=userService.getById(bookingdto.getUserId());
		TripBus bus=tripBusService.getBusById(bookingdto.getBusId());
		booking.setBookingTitle(tripPackage.getPackageName());
		booking.setUser(user);
		booking.setPackagebookingDate(LocalDate.now());
		booking.setNoOfPerson(bookingdto.getNoOfPerson());
		booking.setBookingStatus("BOOKED");
		booking.setTripStatus("NOT_STARTED");
		booking.setTotalCost(tripPackage.getPackagePrice()*bookingdto.getNoOfPerson());
		if(tripPackage.getOfferStatus()) {
			Double finalPrice=bookingdto.getNoOfPerson()*(tripPackage.getPackagePrice()-(tripPackage.getPackagePrice()*(tripPackage.getOfferPercentage()/100)));
			booking.setOfferAmount(finalPrice);
		}
		booking.setBus(bus);
		booking.setPackages(tripPackage);
		return tripBookingRepository.save(booking);
	}
	@Override
	public List<TripBooking> getAllBooking() {
		// TODO Auto-generated method stub
		return tripBookingRepository.findAll();
	}
	@Override
	public TripBooking getBookingById(Long bookingId) {
		// TODO Auto-generated method stub
		return tripBookingRepository.findById(bookingId).get();
	}
	@Override
	public TripBooking cancelBooking(Long bookingId) {
		TripBooking bookingDetail=tripBookingRepository.findById(bookingId).get();
		bookingDetail.setBookingStatus("CANCEL");
		return bookingDetail;
	}

}
