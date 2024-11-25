package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wipro.entity.TripRoute;
import com.wipro.exception.UserException;
import com.wipro.service.RouteService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TripRouteController {
	
	@Autowired
	private RouteService routeService;
	@PostMapping("/admin/route/create")
	public TripRoute createRoute(@RequestBody TripRoute tripRoute) throws UserException {
		try {
			return routeService.createTripRoute(tripRoute);
		}catch(ResponseStatusException e) {
			e.printStackTrace();
			throw new UserException("Failed to create route",e);
		}
	}
	
	@GetMapping("/route/getAllRoutes")
	public List<TripRoute> getAllRoutes() throws UserException{
		try {
			return routeService.getAllRoutes();
		}catch(ResponseStatusException e) {
			e.printStackTrace();
			throw new UserException("Failed to create route",e);
		}
	}
	@GetMapping("/route/getRoutesById/{routeId}")
	public TripRoute getRoutesById(@PathVariable(value="routeId")Long routeId) throws UserException
	{
		try {
			return routeService.getRoutesById(routeId);
		}catch(ResponseStatusException e) {
			e.printStackTrace();
			throw new UserException("Failed to create route",e);
		}
	}
	
	@PutMapping("/admin/route/updateRoute")
	public TripRoute updateRoute(@RequestBody  TripRoute tripRoute) throws UserException {
		try {
			return routeService.updateRoute(tripRoute);
		}catch(ResponseStatusException e) {
			e.printStackTrace();
			throw new UserException("Failed to update route",e);
		}	
	}
	@DeleteMapping("/admin/route/deleteRoute/{routeId}")
	public String deleteRouteById(@PathVariable(value="routeId")Long routeId) throws UserException{
		try {
			return routeService.deleteRouteById(routeId);
		}catch(ResponseStatusException e) {
			e.printStackTrace();
			throw new UserException("Failed to create route",e);
		}
	}
}
