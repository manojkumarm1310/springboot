package com.wipro.entity;

import java.time.LocalDate;

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
public class TripFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long feedbackId;
    private LocalDate dateFeedback;
    private String tripFeedback;
    private Integer tripRating;

  
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Users user;

    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "bookingId")
    private TripBooking tripBooking;
}
