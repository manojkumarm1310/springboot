package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.EventUsers;
import com.wipro.entity.Events;
import com.wipro.service.EventService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/getAll")
    public List<Events> getAllEvents() {
    	
        return eventService.getAllEvents();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Events> getEventById(@PathVariable Long id) {
    	Events event = eventService.getEventById(id);
        if (event != null) {
            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public Events createEvent(@RequestBody Events event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/update")
    public ResponseEntity<Events> updateEvent(@RequestBody Events event) {
    	Events updatedEvent = eventService.updateEvent(event);
        if (updatedEvent != null) {
            return ResponseEntity.ok(updatedEvent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        boolean deleted = eventService.deleteEvent(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{eventId}/register/{userId}")
    public ResponseEntity<Events> registerUserToEvent(
        @PathVariable Long eventId,
        @PathVariable Long userId
    ) {
    	Events event = eventService.registerUserToEvent(eventId, userId);
        if (event != null) {
            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/register/{eventId}")
    public ResponseEntity<Events> register(@PathVariable(value="eventId")Long eventId,@RequestBody EventUsers user){
    	Events event=eventService.registertoEvents(eventId,user);
    	if(event!=null) {
    		return ResponseEntity.ok(event);
    	}
    	return ResponseEntity.notFound().build();
    }
}