package com.wipro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.wipro.entity.TripBooking;
import com.wipro.entity.TripBus;
import com.wipro.enums.BusAvailabilityStatus;
import com.wipro.exception.UserException;
import com.wipro.repository.TripBusRepository;

@Service
public class TripBusServiceImpl implements TripBusService {

	@Autowired
	private TripBusRepository tripBusRepository;
	
	@Override
	public List<TripBus> getAllBus() throws UserException {
		try {
			return tripBusRepository.findAll();
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}

	@Override
	public TripBus getBusById(Long busId) throws UserException {
		try {
			return tripBusRepository.findById(busId).get();
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}

	@Override
	public TripBus createTripBus(TripBus tripBus) throws UserException {
		try {
			tripBus.setAvailableSeat(tripBus.getBusCapacity());			return tripBusRepository.save(tripBus);
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}

	@Override
	public TripBus updateTripBus(TripBus tripBus) throws UserException {
		try {
			System.out.println(tripBus);
			TripBus bus=tripBusRepository.findById(tripBus.getBusId()).get();
			System.out.println(bus);
			bus.setAvailableSeat(tripBus.getAvailableSeat());
			bus.setBusCapacity(tripBus.getBusCapacity());
			bus.setBusNumber(tripBus.getBusNumber());
			bus.setBusType(tripBus.getBusType());
			if(bus.getAvailableStatus().name()=="AVAILABLE") {
				bus.setAvailableStatus(BusAvailabilityStatus.AVAILABLE);
			}
			else {
				bus.setAvailableStatus(BusAvailabilityStatus.UNAVAILABLE);
			}
			return tripBusRepository.save(tripBus);
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}

	@Override
	public void deleteById(Long busId) throws UserException {
		try {
			tripBusRepository.deleteById(busId);
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}
	
}
