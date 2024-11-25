package com.wipro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.wipro.dto.LoginDto;
import com.wipro.dto.RegisterDto;
import com.wipro.entity.TripBooking;
import com.wipro.entity.TripFeedback;
import com.wipro.entity.Users;
import com.wipro.enums.Role;
import com.wipro.exception.UserException;
import com.wipro.payload.RequestPayLoadUser;
import com.wipro.repository.UsersRepository;
@Service
public class UserServiceImpl implements UsersService {

	@Autowired
	private UsersRepository userRepository;
	@Override
	public Users createuser(RegisterDto user) throws UserException {
		try {
			Users isUserExist=userRepository.findByEmail(user.getEmail()).get();
			System.out.println(isUserExist);
			if(isUserExist!=null) {
				throw new UserException("User already exist");
			}
			Users userReg=new Users();
			userReg.setUserName(user.getUserName());
			userReg.setEmail(user.getEmail());
			userReg.setPassword(user.getPassword());
			userReg.setMobile(user.getMobile());
			userReg.setWhatsappNumber(user.getWhatsappNumber());
			userReg.setDateOfBirth(user.getDateOfBirth());
			userReg.setGender(user.getGender());
			userReg.setBookings(new ArrayList<TripBooking>());
			userReg.setTripFeedbacks(new ArrayList<TripFeedback>());
			userReg.setRole(Role.USER);
			return userRepository.save(userReg);
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}
	@Override
	public List<Users> getAllUsers() throws UserException {
		
		try {
			return userRepository.findAll();
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}
	@Override
	public Users getById(Long userId) throws UserException {
		try {
			return userRepository.findById(userId).get();
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}

	}
	@Override
	public Users updateUser(RequestPayLoadUser userPayLoad) throws UserException {
		try {
			
			Users user=this.getById(userPayLoad.getUserId());
			user.setUserName(userPayLoad.getUserName());
			user.setEmail(userPayLoad.getEmail());
			user.setPassword(userPayLoad.getPassword());
			user.setUserAddress(userPayLoad.getUserAddress());
			user.setDateOfBirth(userPayLoad.getDateOfBirth());
			user.setMobile(userPayLoad.getMobile());
			user.setWhatsappNumber(userPayLoad.getWhatsappNumber());
			user.setGender(userPayLoad.getGender());
			return userRepository.save(user);
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}
	@Override
	public String deleteById(Long userId) throws UserException {
		try {
			
			userRepository.deleteById(userId);
			return userId +" is deleted";
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}
	@Override
	public Users getLogin(LoginDto login) {
		System.out.println(userRepository.findByEmailAndPassword(login.getEmail(),login.getPassword()));
		Users user=userRepository.findByEmailAndPassword(login.getEmail(),login.getPassword());
		return user;
	}
}
