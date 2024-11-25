package com.wipro.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TripBooking {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long bookingId;
    
    private String bookingTitle;
    
    private LocalDate tripDate;
    
    private LocalDate packagebookingDate;
    
    private Integer noOfPerson;
    
    private String bookingStatus;
    
    private String tripStatus;
    
    private Double totalCost;
    
    @Column(name="final_price")
    private Double offerAmount;
    
    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Users user;
    
    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "packageId")
    private TripPackage packages;
    
    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "busId")
    private TripBus bus;
    
    
    public TripBooking() {

	}

}
