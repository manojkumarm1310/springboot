package com.wipro.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.EventUsers;
import com.wipro.repository.EventUserRepository;

@Service
public class UserService {

    @Autowired
    private EventUserRepository userRepository;

    public List<EventUsers> getAllUsers() {
        return userRepository.findAll();
    }

    public EventUsers getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public EventUsers createUser(EventUsers user) {
        return userRepository.save(user);
    }

    public EventUsers updateUser(Long id, EventUsers user) {
        if (userRepository.existsById(id)) {
            user.setUserId(id);
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}