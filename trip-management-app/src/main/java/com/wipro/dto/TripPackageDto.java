package com.wipro.dto;

import java.time.LocalDate;
import java.util.List;

import com.wipro.entity.TripPlace;
import com.wipro.entity.TripStopPoint;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TripPackageDto {
	
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
	 
	private String startPoint;
	
	private String endPoint;
	
	private Integer tripDistance;
	
	private List<TripStopPoint> stopPointDetails;
	private LocalDate startDate;
	private Long busId;
}
