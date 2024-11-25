package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.wipro.entity.TripBus;
import com.wipro.entity.TripPackage;
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
			return tripBusRepository.save(tripBus);
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}

	@Override
	public TripBus updateTripBus(TripBus tripBus) throws UserException {
		try {
			return tripBusRepository.save(tripBus);
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}

	@Override
	public String deleteById(Long busId) throws UserException {
		try {
			tripBusRepository.deleteById(busId);
			return busId + "is deleted";
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}
	
}
