package com.wipro.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wipro.enums.Gender;
import com.wipro.enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","ignoreUnknown"})
public class Users implements Serializable , UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long userId;

	private String email;
	
	@JsonIgnore
	private String password;
	
	private String name;
	
	private String userLocation;
	
	private Long mobile;
	
	private LocalDate dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	private Gender Gender;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<TripBooking> bookings;
	@JsonIgnore
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<TripFeedback> tripFeedback;

	public Users(String email, String password, String string3, String string4, Long l, Long m, String string5, Gender male, Role admin) {
		
	}

	public Users() {
	}

	public Users(String email2, String password2, String string3, String string4, long l, long m, LocalDate of,
			Gender male, Role admin) {
		this.setEmail(email2);
		this.setPassword(password2);
		this.setName(string3);
		this.setUserLocation(string4);
		this.setMobile(l);
		this.setDateOfBirth(of);
		this.setGender(male);
		this.setRole(admin);
	}
	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_"+this.getRole().name()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
	
}
