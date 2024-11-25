package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wipro.dto.RegisterDto;
import com.wipro.entity.Users;
import com.wipro.exception.UserException;
import com.wipro.payload.RequestPayLoadUser;
import com.wipro.service.UsersService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UsersService userService;
	
	@PostMapping("/create")
	public Users createUser(@RequestBody RegisterDto user) throws UserException {
		try {
			
			Users registeredUser=userService.createuser(user);
			return registeredUser;
		}catch(ResponseStatusException e) {
			e.printStackTrace();
			throw new UserException("Failed to create user",e);
		}
	}

	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers() throws UserException{
		try {
			return userService.getAllUsers();
			
		}catch (ResponseStatusException e) {
			e.printStackTrace();
			throw new UserException("Failed to get user",e);
		}
	}
	
	@GetMapping("/{userId}")
	public Users getById(@PathVariable(value="userId") Long userId) throws UserException {
		try {
			return userService.getById(userId);
			
		}catch (ResponseStatusException e) {
			e.printStackTrace();
			throw new UserException("Failed to get user",e);
		}
	}
	@PutMapping("/update")
	public Users updateUser(@RequestBody RequestPayLoadUser userPayLoad) throws UserException
	{
		try {
			return userService.updateUser(userPayLoad);
			
		}catch (ResponseStatusException e) {
			e.printStackTrace();
			throw new UserException("Failed to update user",e);
	}
	}
	@DeleteMapping("/delete/{userId}")
	public String deleteById(@PathVariable(value="userId") Long userId) throws UserException {
		try {
			return userService.deleteById(userId);
			
		}catch (ResponseStatusException e) {
			e.printStackTrace();
			throw new UserException("Failed to get user",e);
		}
	}
}
