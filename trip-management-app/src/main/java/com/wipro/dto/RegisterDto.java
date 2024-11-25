package com.wipro.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.wipro.enums.Gender;

import lombok.Data;


@Data
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterDto implements Serializable {
    String email;
    String password;
	String name;
	String userLocation;
	Long mobile;
	LocalDate dateOfBirth;
	Gender gender;
}
