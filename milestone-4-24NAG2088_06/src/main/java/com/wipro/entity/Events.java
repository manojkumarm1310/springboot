package com.wipro.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Events {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long eventId;
	
	private String eventName;
	
	private String eventDescription;
	
	private String eventLocation;
	
	private LocalDate eventDate;
	
	private String startTime;
	
	
	@ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
        name = "event_user",
        joinColumns = @JoinColumn(name = "eventId"),
        inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private Set<EventUsers> users = new HashSet<>();
	
	public Events(){
		
	}
}
