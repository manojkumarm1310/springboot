package com.wipro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.entity.TripBus;
import com.wipro.exception.UserException;

@Service
public interface TripBusService {

	List<TripBus> getAllBus() throws UserException;

	TripBus getBusById(Long busId) throws UserException;

	TripBus createTripBus(TripBus tripBus) throws UserException;

	TripBus updateTripBus(TripBus tripBus) throws UserException;

	void deleteById(Long busId) throws UserException;
	
}
