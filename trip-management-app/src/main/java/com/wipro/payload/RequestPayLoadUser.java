package com.wipro.payload;

import java.time.LocalDate;

import com.wipro.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RequestPayLoadUser {
	
	private Long userId;
	
	private String email;
	
	private String password;
	
	private String userName;
	
	private String userLocation;
	
	private Long mobile;
	
	
	private LocalDate dateOfBirth;
	
	private Gender Gender;
	
}
