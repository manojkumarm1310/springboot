package com.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.dto.CreateUserRequest;
import com.wipro.entity.User;
import com.wipro.exception.InvalidCredentialsException;
import com.wipro.exception.ResourceNotFoundException;
import com.wipro.exception.UserAlreadyExistsException;
import com.wipro.exception.UserNotFoundException;
import com.wipro.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(CreateUserRequest req) {
    	if(userRepository.findByEmail(req.getEmail()).isEmpty() && userRepository.findByUsername(req.getUsername()).isEmpty()) {
    		log.info(req.toString());
    		User user = new User();
    		user.setId(null);
    		user.setUsername(req.getUsername());
    		user.setEmail(req.getEmail());
    		user.setPassword(passwordEncoder.encode(req.getPassword()));
    		user.setRole(req.getRole());
    		log.info(user.toString());
    		return userRepository.save(user);
    	}
    	else {
    		throw new UserAlreadyExistsException(req.getUsername());
    	}
    }
    
    public User loginUser(String email, String password) {
    	User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
    	if(!passwordEncoder.matches(password, user.getPassword()))
    		throw new InvalidCredentialsException();
    	return user;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User getUserByUsername(String username) {
        User user = userRepository.findByUsername(username).get();
        log.info(user.toString());
        return user;
    }
    
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User updateUser(Long id, User updatedUser) {
    	return userRepository.findById(id)
    			.map(user -> {
    				user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
		            return userRepository.save(user);
		        })
    			.orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
    }

    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User with id: " + id + " is deleted";
    }
    
}
