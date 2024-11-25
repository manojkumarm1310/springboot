package com.wipro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.dto.LoginDto;
import com.wipro.dto.RegisterDto;
import com.wipro.entity.Users;
import com.wipro.exception.UserException;
import com.wipro.payload.RequestPayLoadUser;
@Service
public interface UsersService {
	public abstract Users createuser(RegisterDto user) throws UserException;

	public abstract List<Users> getAllUsers() throws UserException;

	public abstract Users getById(Long userId) throws UserException;

	public abstract Users updateUser(RequestPayLoadUser userPayLoad) throws UserException;

	public abstract String deleteById(Long userId) throws UserException;

	public abstract Users getLogin(LoginDto login);
}
