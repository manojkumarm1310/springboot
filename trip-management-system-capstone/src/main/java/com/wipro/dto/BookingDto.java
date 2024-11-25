package com.wipro.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class BookingDto {
	
	private LocalDate tripDate;
	
	private Integer noOfPerson;
	
	private Long packageId;
	
	private Long userId;
	
	private Long busId;
}
