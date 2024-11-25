package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wipro.entity.TripBus;
import com.wipro.exception.UserException;
import com.wipro.service.TripBusService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api")
public class TripBusController {
	
	@Autowired
	private TripBusService tripBusService;
	
	@GetMapping("/bus/getAllBus")
	public List<TripBus> getAllBus() throws UserException{
		try {
			return tripBusService.getAllBus();
		}catch(ResponseStatusException e) {
			e.printStackTrace();
			throw new UserException("Failed to create bus",e);
		}
	}
	
	@GetMapping("/bus/getBusById/{busId}")
	public TripBus getBusById(@PathVariable(value="busId")Long busId) throws UserException {
		try {
			return tripBusService.getBusById(busId);
		}catch(ResponseStatusException e) {
			e.printStackTrace();
			throw new UserException("Failed to create route",e);
		}
	}
	
	@PostMapping("/bus/create")
	public TripBus createTripBus(@RequestBody TripBus tripBus) throws UserException {
		try {
			return tripBusService.createTripBus(tripBus);
		}catch(ResponseStatusException e) {
			e.printStackTrace();
			throw new UserException("Failed to create route",e);
		}
	}
	
	@PutMapping("/bus/update")
	public TripBus updateTripBus(@RequestBody TripBus tripBus) throws UserException {
		try {
			return tripBusService.updateTripBus(tripBus);
		}catch(ResponseStatusException e) {
			e.printStackTrace();
			throw new UserException("Failed to create route",e);
		}
	}
	
	@DeleteMapping("/bus/deleteById/{busId}")
	public String deleteById(@PathVariable(value="busId")Long busId) throws UserException {
		try {
			return tripBusService.deleteById(busId);
		}catch(ResponseStatusException e) {
			e.printStackTrace();
			throw new UserException("Failed to create route",e);
		}
	}
	
}
