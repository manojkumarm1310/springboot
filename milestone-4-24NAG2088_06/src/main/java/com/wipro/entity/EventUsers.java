package com.wipro.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = "events")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EventUsers {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long userId;
	
	
	private String userName;
	
	private String email;
	
	private Long mobile;
	
	@JsonBackReference
    @ManyToMany(mappedBy = "users",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Events> events = new HashSet<>();
	
    public EventUsers(){
    	
    }
	
}
