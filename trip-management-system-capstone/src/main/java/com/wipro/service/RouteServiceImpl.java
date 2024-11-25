package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.wipro.entity.TripRoute;
import com.wipro.entity.TripStopPoint;
import com.wipro.exception.UserException;
import com.wipro.repository.TripRouteRepository;

@Service
public class RouteServiceImpl implements RouteService{

	@Autowired
	private TripRouteRepository tripRouteRepository;

    
	@Override
	public TripRoute createTripRoute(TripRoute tripRoute) throws UserException {
		try {
//			TripRoute temp=tripRoute;
			List<TripStopPoint> stopPoints=tripRoute.getStopPointsDetails();
			for(TripStopPoint point:stopPoints) {
				point.setRoute(tripRoute);
			}
//			temp.setStopPointsDetails(tripRoute.getStopPointsDetails());
			return tripRouteRepository.save(tripRoute);
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}

	@Override
	public List<TripRoute> getAllRoutes() throws UserException{
		try {
			return tripRouteRepository.findAll();
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}

	@Override
	public TripRoute getRoutesById(Long routeId) throws UserException{
		try {
			return tripRouteRepository.findById(routeId).get();
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}

	@Override
	public String deleteRouteById(Long routeId) throws UserException {
		try {
			tripRouteRepository.deleteById(routeId);
			return routeId + " route is deleted";
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}

	@Override
	public TripRoute updateRoute(TripRoute tripRoute) throws UserException {
		try {
			
			return tripRouteRepository.save(tripRoute);
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}

}
