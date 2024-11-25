
package com.wipro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dto.TripPackageDto;
import com.wipro.entity.TripBooking;
import com.wipro.entity.TripPackage;
import com.wipro.entity.TripPlace;
import com.wipro.entity.TripRoute;
import com.wipro.entity.TripStopPoint;
import com.wipro.exception.UserException;
import com.wipro.repository.TripPackageRepository;
import com.wipro.repository.TripRouteRepository;

@Service
public class TripPackageServiceImpl implements TripPackageService {

	@Autowired
	private TripPackageRepository tripPackageRepository;
	
	@Autowired
	private TripRouteRepository tripRouteRepository;
	@Override
	public TripPackage createPackage(TripPackage tripPackage) {
		List<TripPlace> places=tripPackage.getPlaces();
		
		
		if (tripPackage.getRoute() != null && tripPackage.getRoute().getRouteId() != null) {
            Optional<TripRoute> routeOpt = tripRouteRepository.findById(tripPackage.getRoute().getRouteId());
            if (routeOpt.isPresent()) {
                tripPackage.setRoute(routeOpt.get());
            } else {
                throw new RuntimeException("Route not found");
            }
        }
		if(places==null) {
			places=new ArrayList<TripPlace>();
		}
		tripPackage.setBookings(new ArrayList<TripBooking>());
		for(TripPlace place:places) {
			place.setPackages(tripPackage);
		}
		

		TripPackage createdTripPackage=tripPackageRepository.save(tripPackage);
		return createdTripPackage;
	}
	@Override
	public List<TripPackage> getAllPackage() {
		return tripPackageRepository.findAll();
	}
	@Override
	public TripPackage getPackageById(Long packageId) {
		return tripPackageRepository.findById(packageId).get();
	}
	
	@Override
    public TripPackage updatePackage(Long packageId, TripPackage tripPackage) {
        Optional<TripPackage> existingPackageOpt = tripPackageRepository.findById(packageId);
        if (!existingPackageOpt.isPresent()) {
            throw new RuntimeException("Package not found");
        }
        TripPackage existingPackage = existingPackageOpt.get();
        existingPackage.setPackageName(tripPackage.getPackageName());
        existingPackage.setPackageType(tripPackage.getPackageType());
        existingPackage.setTripDuration(tripPackage.getTripDuration());
        existingPackage.setPackagePrice(tripPackage.getPackagePrice());
        existingPackage.setDescription(tripPackage.getDescription());
        existingPackage.setOfferStatus(tripPackage.getOfferStatus());
        existingPackage.setOfferPercentage(tripPackage.getOfferPercentage());
        existingPackage.setGuideName(tripPackage.getGuideName());
        existingPackage.setGuideNumber(tripPackage.getGuideNumber());
        existingPackage.setGuideEmail(tripPackage.getGuideEmail());
        
        if (tripPackage.getPlaces() != null) {
            existingPackage.setPlaces(tripPackage.getPlaces());
        }
        
        if (tripPackage.getRoute() != null && tripPackage.getRoute().getRouteId() != null) {
            Optional<TripRoute> routeOpt = tripRouteRepository.findById(tripPackage.getRoute().getRouteId());
            if (routeOpt.isPresent()) {
                existingPackage.setRoute(routeOpt.get());
            } else {
                throw new RuntimeException("Route not found");
            }
        }
        return tripPackageRepository.save(existingPackage);
    }
	@Override
	public TripPackage createPackageDetail(TripPackageDto tripPackagedto) throws UserException {
		TripPackage tripPackage=new TripPackage();
		tripPackage.setDescription(tripPackagedto.getDescription());
		tripPackage.setGuideName(tripPackagedto.getGuideName());
		tripPackage.setGuideEmail(tripPackagedto.getGuideEmail());
		tripPackage.setGuideNumber(tripPackage.getGuideNumber());
		if(tripPackagedto.getOfferStatus()) {
			tripPackage.setOfferPercentage(tripPackagedto.getOfferPercentage());
		}else {
			tripPackage.setOfferPercentage(0);
		}
		tripPackage.setOfferStatus(tripPackagedto.getOfferStatus());
		tripPackage.setPackageName(tripPackagedto.getPackageName());
		tripPackage.setPackagePrice(tripPackagedto.getPackagePrice());
		tripPackage.setPackageType(tripPackagedto.getPackageType());
		if(tripPackagedto.getPlaces().isEmpty()) {
			tripPackage.setPlaces(new ArrayList<TripPlace>());
		}
		tripPackage.setPlaces(tripPackagedto.getPlaces());
		tripPackage.setTripDuration(tripPackagedto.getTripDuration());
		TripRoute route=new TripRoute();
		route.setStartPoint(tripPackagedto.getStartPoint());
		route.setEndPoint(tripPackagedto.getEndPoint());
		route.setTripDistance(tripPackagedto.getTripDistance());
		if(tripPackagedto.getStopPointDetails().isEmpty()) {
			route.setStopPointsDetails(new ArrayList<TripStopPoint>());
		}else {
		for (TripStopPoint stopPoint : tripPackagedto.getStopPointDetails()) {
	        stopPoint.setRoute(route); // Set route reference
	    }
		route.setStopPointsDetails(tripPackagedto.getStopPointDetails());
		}
		if(tripRouteRepository.save(route)==null) {
			throw new UserException("Route not added properly");
		}
		tripPackage.setRoute(route);
		System.out.println(tripPackage);
		return this.createPackage(tripPackage); 
		
		
	}
	
	
	
	
	
	
}
