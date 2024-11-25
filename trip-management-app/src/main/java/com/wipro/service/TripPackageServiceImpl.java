
package com.wipro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dto.TripPackageDto;
import com.wipro.entity.TripBooking;
import com.wipro.entity.TripBus;
import com.wipro.entity.TripPackage;
import com.wipro.entity.TripPlace;
import com.wipro.entity.TripRoute;
import com.wipro.entity.TripStopPoint;
import com.wipro.enums.BusAvailabilityStatus;
import com.wipro.exception.UserException;
import com.wipro.repository.TripBusRepository;
import com.wipro.repository.TripPackageRepository;
import com.wipro.repository.TripRouteRepository;
import com.wipro.repository.TripStopPointRepository;

import jakarta.transaction.Transactional;

@Service
public class TripPackageServiceImpl implements TripPackageService {

	@Autowired
	private TripPackageRepository tripPackageRepository;
	
	@Autowired
	private TripBusRepository tripBusRepository;
	
	@Autowired
	private TripRouteRepository tripRouteRepository;
	
	@Autowired
	private TripStopPointRepository tripStopPointRepository;
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
	public TripPackage updatePackage(Long packageId, TripPackageDto tripPackageDto) {
	    // Retrieve the existing package
	    Optional<TripPackage> existingPackageOpt = tripPackageRepository.findById(packageId);
	    if (!existingPackageOpt.isPresent()) {
	        throw new RuntimeException("Package not found");
	    }

	    TripPackage existingPackage = existingPackageOpt.get();

	    // Update the existing package details
	    existingPackage.setPackageName(tripPackageDto.getPackageName());
	    existingPackage.setPackageType(tripPackageDto.getPackageType());
	    existingPackage.setTripDuration(tripPackageDto.getTripDuration());
	    existingPackage.setPackagePrice(tripPackageDto.getPackagePrice());
	    existingPackage.setStartDate(tripPackageDto.getStartDate());
	    existingPackage.setDescription(tripPackageDto.getDescription());
	    existingPackage.setOfferStatus(tripPackageDto.getOfferStatus());
	    existingPackage.setOfferPercentage(tripPackageDto.getOfferPercentage());
	    existingPackage.setGuideName(tripPackageDto.getGuideName());
	    existingPackage.setGuideNumber(tripPackageDto.getGuideNumber());
	    existingPackage.setGuideEmail(tripPackageDto.getGuideEmail());

	    // Update the bus if provided
	    if (tripPackageDto.getBusId() != null) {
	        Optional<TripBus> busOpt = tripBusRepository.findById(tripPackageDto.getBusId());
	        if (busOpt.isPresent()) {
	            TripBus existingBus = busOpt.get();
	            existingPackage.setBus(existingBus); // Set the full bus object with all fields
	        } else {
	            throw new RuntimeException("Bus not found with ID: " + tripPackageDto.getBusId());
	        }
	    }

	    // Update or create route
	    TripRoute route = existingPackage.getRoute();
	    if (route == null) {
	        route = new TripRoute();
	    }
	    
	    route.setStopPointsDetails(new ArrayList<>());
	    route=tripRouteRepository.save(route);
	    
	    route.setStartPoint(tripPackageDto.getStartPoint());
	    route.setEndPoint(tripPackageDto.getEndPoint());
	    route.setTripDistance(tripPackageDto.getTripDistance());
	    
	    existingPackage.getRoute().getStopPointsDetails().clear();
	    // Update or create stop points
	    List<TripStopPoint> newStopPoints = tripPackageDto.getStopPointDetails();
	    if (newStopPoints != null) {
	        List<TripStopPoint> existingStopPoints = route.getStopPointsDetails();
	        if (existingStopPoints == null) {
	            existingStopPoints = new ArrayList<>();
	        }

	        Map<Long, TripStopPoint> existingStopPointsMap = existingStopPoints.stream()
	                .collect(Collectors.toMap(TripStopPoint::getStopPointId, stopPoint -> stopPoint));

	        for (TripStopPoint newStopPoint : newStopPoints) {
	            if (newStopPoint.getStopPointId() != null && existingStopPointsMap.containsKey(newStopPoint.getStopPointId())) {
	                // Update existing stop point
	                TripStopPoint existingStopPoint = existingStopPointsMap.get(newStopPoint.getStopPointId());
	                existingStopPoint.setStopName(newStopPoint.getStopName());
	                existingStopPoint.setStayRequired(newStopPoint.getStayRequired());
	                existingStopPoint.setHotelName(newStopPoint.getHotelName());
	                existingStopPoint.setHotelAddress(newStopPoint.getHotelAddress());
	                existingStopPoint.setHotelType(newStopPoint.getHotelType());
	                existingStopPoint.setStayDayCount(newStopPoint.getStayDayCount());
	            } else {
	                // Create new stop point
	                newStopPoint.setRoute(route);
	                existingStopPoints.add(newStopPoint);
	            }
	        }

	        route.setStopPointsDetails(existingStopPoints);
	    }


	    // Save the route
	    tripRouteRepository.save(route);

	    // Set the updated route in the existing package
	    existingPackage.setRoute(route);

	    // Save the updated package
	    return tripPackageRepository.save(existingPackage);
	}

	
//	@Override
//    public TripPackage updatePackage(Long packageId, TripPackageDto tripPackage) {
//        Optional<TripPackage> existingPackageOpt = tripPackageRepository.findById(packageId);
//        if (!existingPackageOpt.isPresent()) {
//            throw new RuntimeException("Package not found");
//        }
//        System.out.println(existingPackageOpt);
//        System.out.println(tripPackage);
//        TripPackage existingPackage = existingPackageOpt.get();
//        existingPackage.setPackageName(tripPackage.getPackageName());
//        existingPackage.setPackageType(tripPackage.getPackageType());
//        existingPackage.setTripDuration(tripPackage.getTripDuration());
//        existingPackage.setPackagePrice(tripPackage.getPackagePrice());
//        existingPackage.setStartDate(tripPackage.getStartDate());
//        existingPackage.setDescription(tripPackage.getDescription());
//        existingPackage.setOfferStatus(tripPackage.getOfferStatus());
//        existingPackage.setOfferPercentage(tripPackage.getOfferPercentage());
//        existingPackage.setGuideName(tripPackage.getGuideName());
//        existingPackage.setGuideNumber(tripPackage.getGuideNumber());
//        existingPackage.setGuideEmail(tripPackage.getGuideEmail());
//       
//        if (tripPackage.getPlaces() != null) {
//            existingPackage.setPlaces(tripPackage.getPlaces());
//        }
//        
//        
//        if(tripPackage.getPlaces().isEmpty()) {
//			existingPackage.setPlaces(new ArrayList<TripPlace>());
//		}
//		
//		if(tripPackage.getBusId()!=null) {
//			
//			Optional<TripBus> busOpt = tripBusRepository.findById(tripPackage.getBusId());
//	        if (busOpt.isPresent()) {
//	        	TripBus existingBus=busOpt.get();
//	            existingPackage.setBus(existingBus); // Set the full bus object with all fields
//	        } else {
//	            throw new RuntimeException("Bus not found with ID: " + tripPackage.getBusId());
//	        }
//		}
////		tripPackage.setPlaces(tripPackage.getPlaces());
//		tripPackage.setTripDuration(tripPackage.getTripDuration());
//		
//		
//		TripRoute route=existingPackage.getRoute();
//		if(route==null) {
//			route =new TripRoute();
//		}
//		
//		
//		route.setStartPoint(tripPackage.getStartPoint());
//		route.setEndPoint(tripPackage.getEndPoint());
//		route.setTripDistance(tripPackage.getTripDistance());
//		
//	    List<TripStopPoint> newStopPoints = tripPackage.getStopPointDetails();
//	    if (newStopPoints != null ) {
//	        for (TripStopPoint stopPoint : newStopPoints) {
//	            // Check if the stop point has an ID
//	            if (stopPoint.getStopPointId() != null) {
//	                // If stop point exists, update it
//	                TripStopPoint existingStopPoint = tripStopPointRepository.findById(stopPoint.getStopPointId())
//	                        .orElse(new TripStopPoint());
//	                existingStopPoint.setStopName(stopPoint.getStopName());
//	                existingStopPoint.setStayRequired(stopPoint.getStayRequired());
//	                existingStopPoint.setHotelName(stopPoint.getHotelName());
//	                existingStopPoint.setHotelAddress(stopPoint.getHotelAddress());
//	                existingStopPoint.setHotelType(stopPoint.getHotelType());
//	                existingStopPoint.setStayDayCount(stopPoint.getStayDayCount());
//	                existingStopPoint.setRoute(route); // Link the stop point to the route
//	                route.getStopPointsDetails().add(existingStopPoint);
//	            } else {
//	                // If stop point does not have an ID, create a new one
//	                stopPoint.setRoute(route); // Link the stop point to the route
//	                route.getStopPointsDetails().add(stopPoint);
//	            }
//	        }
//	    }
//
//
//	    tripRouteRepository.save(route);
//	    
//	    existingPackage.setRoute(route);
//	    
//        return tripPackageRepository.save(existingPackage);
//    }
	@Override
	public TripPackage createPackageDetail(TripPackageDto tripPackagedto) throws UserException {
		TripPackage tripPackage=new TripPackage();
		System.out.println(tripPackagedto);
		tripPackage.setDescription(tripPackagedto.getDescription());
		tripPackage.setGuideName(tripPackagedto.getGuideName());
		tripPackage.setGuideEmail(tripPackagedto.getGuideEmail());
		tripPackage.setGuideNumber(tripPackagedto.getGuideNumber());
		if(tripPackagedto.getOfferStatus()) {
			tripPackage.setOfferPercentage(tripPackagedto.getOfferPercentage());
		}else {
			tripPackage.setOfferPercentage(0);
		}
		tripPackage.setOfferStatus(tripPackagedto.getOfferStatus());
		tripPackage.setPackageName(tripPackagedto.getPackageName());
		tripPackage.setPackagePrice(tripPackagedto.getPackagePrice());
		tripPackage.setPackageType(tripPackagedto.getPackageType());
		tripPackage.setStartDate(tripPackagedto.getStartDate());
		if(tripPackagedto.getPlaces().isEmpty()) {
			tripPackage.setPlaces(new ArrayList<TripPlace>());
		}
		 
		if(tripPackagedto.getBusId()!=null) {
			
			Optional<TripBus> busOpt = tripBusRepository.findById(tripPackagedto.getBusId());
	        if (busOpt.isPresent()) {
	            tripPackage.setBus(busOpt.get()); // Set the full bus object with all fields
	            TripBus bus =tripBusRepository.findById(tripPackagedto.getBusId()).get();
	    		bus.setAvailableStatus(BusAvailabilityStatus.UNAVAILABLE);
	    		tripBusRepository.save(bus);
	        } else {
	            throw new RuntimeException("Bus not found with ID: " + tripPackagedto.getBusId());
	        }
		}
		
		tripPackage.setPlaces(tripPackagedto.getPlaces());
		tripPackage.setTripDuration(tripPackagedto.getTripDuration());
		TripRoute route=new TripRoute();
		route.setStartPoint(tripPackagedto.getStartPoint());
		route.setEndPoint(tripPackagedto.getEndPoint());
		route.setTripDistance(tripPackagedto.getTripDistance());
		if(tripPackagedto.getStopPointDetails()==null) {
			route.setStopPointsDetails(new ArrayList<TripStopPoint>());
		}else {
			 List<TripStopPoint> stopPoints = tripPackagedto.getStopPointDetails();
		for (TripStopPoint stopPoint : stopPoints) {
	        stopPoint.setRoute(route); // Set route reference
	    }
		route.setStopPointsDetails(stopPoints);
		}
		if(tripRouteRepository.save(route)==null) {
			throw new UserException("Route not added properly");
		}
		tripPackage.setRoute(route);
		System.out.println(tripPackage);
		return this.createPackage(tripPackage); 
		
		
	}
	@Override
	public void deletePackageById(Long packageId) {
		Long busId=tripPackageRepository.findById(packageId).get().getBus().getBusId();
		tripPackageRepository.deleteById(packageId);
		tripBusRepository.deleteById(busId);
	}
	
	
	
	
	
	
}
