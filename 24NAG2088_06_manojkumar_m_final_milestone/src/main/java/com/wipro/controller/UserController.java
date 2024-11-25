package com.wipro.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.CreateUserRequest;
import com.wipro.dto.LoginDto;
import com.wipro.dto.UserResponse;
import com.wipro.entity.User;
import com.wipro.security.JwtUtilities;
import com.wipro.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private JwtUtilities jwtUtilities;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest user) {
    	log.info(user.toString());
        User createdUser = userService.createUser(user);
        var userResponse = modelMapper.map(createdUser, UserResponse.class);
		userResponse.setToken(jwtUtilities.generateToken(user.getUsername(), user.getRole()));
		return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody LoginDto req) {
    	User user = userService.loginUser(req.getEmail(), req.getPassword());
    	var userResponse = modelMapper.map(user, UserResponse.class);
		userResponse.setToken(jwtUtilities.generateToken(user.getUsername(), user.getRole()));
		return ResponseEntity.ok(userResponse);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id)
            .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        User user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }
    
    @GetMapping("/parsetoken")
	public ResponseEntity<String> parseToken(@RequestParam("token") String token) {
		String username = jwtUtilities.extractUsername(token);
		return ResponseEntity.ok(username);
	}

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
		return ResponseEntity.ok(userService.updateUser(id, updatedUser));
	}
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
}
