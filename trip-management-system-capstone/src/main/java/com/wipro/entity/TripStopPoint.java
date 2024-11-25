package com.wipro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Setter
@Getter
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TripStopPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long stopPointId;
    
    private String stopName;
    
    private Boolean stayRequired;
    
    private String hotelName;
    
    private String hotelAddress;
    
    private String hotelType;
    
    private Integer stayDayCount;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "routeId")
    @JsonIgnore
    private TripRoute route;
    
    public TripStopPoint() {
    	
    }

}
