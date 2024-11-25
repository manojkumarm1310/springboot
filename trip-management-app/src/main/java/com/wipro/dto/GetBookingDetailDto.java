package com.wipro.dto;

import java.util.List;

import com.wipro.entity.TripBooking;
import com.wipro.entity.TripPackage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetBookingDetailDto {
	public GetBookingDetailDto() {
		// TODO Auto-generated constructor stub
	}

	private List<TripBooking> tripBooking;
	
	private List<TripPackage> tripPackage;
}
