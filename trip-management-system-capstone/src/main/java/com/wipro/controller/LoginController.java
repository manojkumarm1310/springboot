package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.LoginDto;
import com.wipro.entity.Users;
import com.wipro.service.UsersService;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private UsersService userService;
	
	@PostMapping("/login")
	public ResponseEntity<Users> login(@RequestBody LoginDto login) {
		return ResponseEntity.ok(userService.getLogin(login));
	}
}
