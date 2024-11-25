package com.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.EventUsers;
import com.wipro.entity.Events;
import com.wipro.repository.EventUserRepository;
import com.wipro.repository.EventsRepository;

@Service
public class EventService {

    @Autowired
    private EventsRepository eventRepository;

    @Autowired
    private EventUserRepository userRepository;

    public List<Events> getAllEvents() {
        return eventRepository.findAll();
    }

    public Events getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Events createEvent(Events event) {
        return eventRepository.save(event);
    }

    public Events updateEvent(Events event) {
        if (eventRepository.existsById(event.getEventId())) {
            event.setEventId(event.getEventId());
            return eventRepository.save(event);
        } else {
            return null;
        }
    }

    public boolean deleteEvent(Long id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Events registerUserToEvent(Long eventId, Long userId) {
        Optional<Events> eventOpt = eventRepository.findById(eventId);
        Optional<EventUsers> userOpt = userRepository.findById(userId);

        if (eventOpt.isPresent() && userOpt.isPresent()) {
            Events event = eventOpt.get();
            EventUsers user = userOpt.get();
            event.getUsers().add(user);
            user.getEvents().add(event);
            eventRepository.save(event);
            userRepository.save(user);

            return event;
        } else {
            return null;
        }
    }

	public Events registertoEvents(Long eventId, EventUsers user) {
		EventUsers eventUser=userRepository.save(user);
		if(eventUser!=null) {
			Long userId=eventUser.getUserId();
			Events event=this.registerUserToEvent(eventId, userId);
			return event;
		}
		return null;
	}
}