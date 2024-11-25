package com.wipro.entity;


import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class TripPackage {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	
	private Long packagedId;
	
	private String packageName;
	
	private String packageType;
	
	private String tripDuration;
	
	private Double packagePrice;
	
	private String description;
	
	private LocalDate startDate;
	
	private Boolean offerStatus;
	
	private Integer offerPercentage;
	
	private String guideName;
	
	private Long  guideNumber;
	
	private String guideEmail;
	
	@OneToMany(mappedBy = "packages",cascade=CascadeType.ALL)
    private List<TripPlace> places;
	
	@JsonIgnore
	@OneToMany(mappedBy = "packages",cascade=CascadeType.ALL)
    private List<TripBooking> bookings;
	
	@OneToOne
	private TripBus bus;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "routeId")
    private TripRoute route;
	
	public TripPackage() {
		
	}
	
}
