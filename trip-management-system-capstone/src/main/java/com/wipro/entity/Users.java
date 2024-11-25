package com.wipro.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wipro.enums.Gender;
import com.wipro.enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long userId;

	private String email;
	
	private String password;
	
	private String userName;
	
	private String userAddress;
	
	private Long mobile;
	
	private Long whatsappNumber;
	
	private LocalDate dateOfBirth;
	
	private Gender Gender;
	
	private Role role;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<TripBooking> bookings;
	@JsonIgnore
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<TripFeedback> tripFeedbacks;

	public Users(String email, String password, String string3, String string4, Long l, Long m, String string5, Gender male, Role admin) {
		
	}

	public Users() {
	}

	public Users(String email2, String password2, String string3, String string4, long l, long m, LocalDate of,
			Gender male, Role admin) {
		this.setEmail(email2);
		this.setPassword(password2);
		this.setUserName(string3);
		this.setUserAddress(string4);
		this.setMobile(l);
		this.setWhatsappNumber(m);
		this.setDateOfBirth(of);
		this.setGender(male);
		this.setRole(admin);
	}
	
}
