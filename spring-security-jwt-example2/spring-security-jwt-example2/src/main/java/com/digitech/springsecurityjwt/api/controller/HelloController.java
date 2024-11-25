package com.digitech.springsecurityjwt.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digitech.springsecurityjwt.api.entity.AuthRequest;
import com.digitech.springsecurityjwt.api.util.JwtUtil;

@RestController
public class HelloController {
	@Autowired
	private JwtUtil jwtUtil;	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	/*
	 * copy the jwt token, in postman headers, paste preceding with
	 * word, bearer and run http://localhost:9191/,
	 * gives 403 error. So we need to add an filter to 
	 * inform spring application to authenticate the request with
	 * the specified jwt token in the header
	 * Ex. Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMiIsImV4cCI6MTU5NjE1NTU2OSwiaWF0IjoxNTk2MTE5NTY5fQ.xET_GLLlIPQIoCyUFSDJd662vAAAoyVXNh_GflaJgE0
	   You shoukd get Welcome to yamaha message	
	 */
	/*
	 * Now uncheck the Authorization headr and again send in postman,
	 * we will get 403 error which means our get request is following
	 * stateless authentication and also the jwt token is neither stored in server
	 * 
	 */
	@GetMapping("/")
	public String hello() {
		return "Welcome to yamaha";
	}
	
	/*
	 * http://localhost:9191/authenticate
	 * In the body type the following json object
	 * {
        "userName": "user2",
        "password": "pwd2"
  		}
	 * In the headers section of postman, uncheck Authorization,
	 * you will get JWT token
	 */
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword()));
		}catch(Exception e) {
			throw new Exception("Invalid credentials");
		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}
	
}
