package com.wipro.dto;

import java.util.List;

import com.wipro.entity.TripBooking;
import com.wipro.entity.TripPlace;

public class PackageDto {
	private String packageName;
	
	private String packageType;
	
	private String tripDuration;
	
	private Double packagePrice;
	
	private String description;
	
	private Boolean offerStatus;
	
	private Integer offerPercentage;
	
	private String guideName;
	
	private Long  guideNumber;
	
	private String guideEmail;
	
	private List<TripPlace> places;
	
	private List<TripBooking> bookings;
	 
	private Long routeId;
	
	
}
