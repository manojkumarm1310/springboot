package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.LoginDto;
import com.wipro.dto.ReqRes;
import com.wipro.repository.UsersRepository;
import com.wipro.service.UsersService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private UsersService userService;
	@Autowired
	private UsersRepository userRepo;
	
	@PostMapping("/login")
	public ResponseEntity<ReqRes> login(@RequestBody LoginDto login) {
		
		return ResponseEntity.ok(userService.getLogin(login));
	}
	
//	@GetMapping("/admin/")
//	public String hello() {
//		return "Verified";
//	}
}
