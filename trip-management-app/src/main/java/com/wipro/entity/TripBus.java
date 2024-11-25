package com.wipro.entity;

import java.util.List;

import com.wipro.enums.BusAvailabilityStatus;

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
@Setter
@Getter
@ToString
public class TripBus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long busId;
    
    private String busNumber;
    
    private String busType;
    
    private Integer busCapacity;
    
    private BusAvailabilityStatus availableStatus;
    
    private Integer availableSeat;
        
    public TripBus() {
    	
    }
}
