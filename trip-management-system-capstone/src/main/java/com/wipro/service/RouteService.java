package com.wipro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.entity.TripRoute;
import com.wipro.exception.UserException;

@Service
public interface RouteService {
	public abstract TripRoute createTripRoute(TripRoute tripRoute) throws UserException;
	public abstract List<TripRoute> getAllRoutes() throws UserException;
	public abstract TripRoute getRoutesById(Long routeId) throws UserException;
	public abstract String deleteRouteById(Long routeId) throws UserException;
	public abstract TripRoute updateRoute(TripRoute tripRoute) throws UserException;
}
