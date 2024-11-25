
package com.wipro.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dto.BookingDto;
import com.wipro.entity.TripBooking;
import com.wipro.entity.TripBus;
import com.wipro.entity.TripPackage;
import com.wipro.entity.Users;
import com.wipro.enums.BusAvailabilityStatus;
import com.wipro.exception.UserException;
import com.wipro.repository.TripBookingRepository;
import com.wipro.repository.TripBusRepository;

@Service
public class TripBookingServiceImpl implements TripBookingService{

	@Autowired
	private TripPackageService tripPackageService;
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private TripBusService tripBusService;
	
	@Autowired
	private TripBusRepository tripBusRepository;
	
	
	@Autowired
	private TripBookingRepository tripBookingRepository;
	@Override
	public TripBooking bookTrip(Long packageId,Long userId,BookingDto bookingdto) throws UserException {
		TripBooking booking =new TripBooking();
		TripPackage tripPackage=tripPackageService.getPackageById(packageId);
		Users user=userService.getById(userId);
		booking.setBookingTitle(tripPackage.getPackageName());
		booking.setUser(user);
		booking.setPackagebookingDate(LocalDate.now());
		booking.setNoOfPerson(bookingdto.getNoOfPerson());
		booking.setBookingStatus("BOOKED");
		booking.setTripStatus("NOT_STARTED");
	
		TripBus bus=tripPackage.getBus();
		bus.setAvailableSeat(bus.getAvailableSeat()-bookingdto.getNoOfPerson());
		if(bus.getAvailableSeat()==0) {
			bus.setAvailableStatus(BusAvailabilityStatus.UNAVAILABLE);
		}
		tripBusRepository.save(bus);
		
		
		booking.setTotalCost(tripPackage.getPackagePrice()*bookingdto.getNoOfPerson());
		if(tripPackage.getOfferStatus()) {
			Double finalPrice=bookingdto.getNoOfPerson()*(tripPackage.getPackagePrice()-(tripPackage.getPackagePrice()*((double)tripPackage.getOfferPercentage()/100)));
			booking.setOfferAmount(finalPrice);
		}
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
	public List<TripBooking> getAllPackagesForOneUser(Long userId) {
		List<TripBooking> allBookingDetail=this.getAllBooking();
		System.out.println(allBookingDetail);
		List<TripBooking> AllPackagesForOne=new ArrayList<>();
		
		for(TripBooking bookingByUser:allBookingDetail) {
			if(bookingByUser.getUser().getUserId().equals(userId)) {
				System.out.println(bookingByUser);
				AllPackagesForOne.add(bookingByUser);
			}
		}
		return AllPackagesForOne;
	}
	
	
	

}
