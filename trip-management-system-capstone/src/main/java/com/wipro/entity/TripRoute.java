package com.wipro.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TripRoute {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long routeId;
	
	@Column(name="source",nullable=false)
	private String startPoint;
	
	@Column(name="destination",nullable=false)
	private String endPoint;
	
	private Integer tripDistance;
	
	
	@OneToMany(mappedBy = "route",cascade=CascadeType.ALL)
    private List<TripStopPoint> stopPointsDetails;
	
	@JsonIgnore
	@OneToMany(mappedBy = "route",cascade=CascadeType.ALL)
    private List<TripPackage> packages;
	public TripRoute() {
		
	}
}
