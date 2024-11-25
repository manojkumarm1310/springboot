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
import com.wipro.dto.UpdateUserdto;
import com.wipro.entity.TripBooking;
import com.wipro.entity.Users;
import com.wipro.exception.UserException;
import com.wipro.payload.RequestPayLoadUser;
import com.wipro.service.TripBookingService;
import com.wipro.service.UsersService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private TripBookingService tripBookingService;
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

	@GetMapping("/admin/getAllUsers")
	public List<Users> getAllUsers() throws UserException{
		try {
			return userService.getAllUsers();
			
		}catch (ResponseStatusException e) {
			e.printStackTrace();
			throw new UserException("Failed to get user",e);
		}
	}
	
	@PutMapping("/update/{userId}")
	public Users updateUser(@PathVariable(value="userId")Long userId, @RequestBody UpdateUserdto user) throws UserException {
		System.out.println(user);	
		return userService.updateUser(userId,user);
	}
	
	@GetMapping("/{userId}")
	public Users getById(@PathVariable(value="userId") Long userId) throws UserException {
		try {
			System.out.println(userId);
			return userService.getById(userId);
			
		}catch (ResponseStatusException e) {
			e.printStackTrace();
			throw new UserException("Failed to get user",e);
		}
	}
	
	@DeleteMapping("/admin/delete/{userId}")
	public String deleteById(@PathVariable(value="userId") Long userId) throws UserException {
		try {
			return userService.deleteById(userId);
			
		}catch (ResponseStatusException e) {
			e.printStackTrace();
			throw new UserException("Failed to get user",e);
		}
	}
	
	@GetMapping("/bookingdetails/{userId}")
	public List<TripBooking> getBookingDetail(@PathVariable(value="userId")Long userId){
		return userService.getAllBookingDetails(userId);
	}
	
	@PutMapping("/booking/cancelbooking/{bookingId}")
	public TripBooking cancelBooking(@PathVariable(value="bookingId")Long bookingId) {
		System.out.println(bookingId);
		return userService.cancelBooking(bookingId);
	}
	
	
}
