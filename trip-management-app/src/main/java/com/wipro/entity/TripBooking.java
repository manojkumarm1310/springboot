package com.wipro.entity;

import java.time.LocalDate;
import java.util.List;

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
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
    
    private LocalDate packagebookingDate;
    
    private Integer noOfPerson;
    
    private String bookingStatus;
    
    private String tripStatus;
    
    private Double totalCost;
    
    @Column(name="final_price")
    private Double offerAmount;
    
   
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Users user;
    
   
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "packageId")
    private TripPackage packages;
    
    
    @JsonIgnore
    @OneToMany(mappedBy="booking", cascade=CascadeType.ALL)
    private List<TripFeedback> tripFeedback;

    
    
    public TripBooking() {

	}

}
