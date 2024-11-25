package com.wipro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.dto.LoginDto;
import com.wipro.dto.RegisterDto;
import com.wipro.dto.ReqRes;
import com.wipro.dto.UpdateUserdto;
import com.wipro.entity.TripBooking;
import com.wipro.entity.Users;
import com.wipro.exception.UserException;
@Service
public interface UsersService {
	public abstract Users createuser(RegisterDto user) throws UserException;

	public abstract List<Users> getAllUsers() throws UserException;

	public abstract Users getById(Long userId) throws UserException;

	public abstract Users updateUser(Long userId,UpdateUserdto userPayLoad) throws UserException;

	public abstract String deleteById(Long userId) throws UserException;

	public abstract ReqRes getLogin(LoginDto login);

	public abstract List<TripBooking> getAllBookingDetails(Long userId);

	public abstract TripBooking cancelBooking(Long bookingId);
}
