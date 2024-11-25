package com.wipro.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.dao.RoleRepository;
import com.wipro.dao.UserRepository;
import com.wipro.dto.AuthResponseDto;
import com.wipro.dto.LoginDto;
import com.wipro.model.Role;
import com.wipro.model.User;
import com.wipro.service.AuthService;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
   @Autowired
   private AuthService authService;
   // Build Login REST API
   @PostMapping("/login")
   public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){
       
	   //01 - Receive the token from AuthService
	   
       String token = authService.login(loginDto);
       
       //02 - Set the token as a response using JwtAuthResponse Dto class
       
       AuthResponseDto authResponseDto = new AuthResponseDto();
       
       authResponseDto.setAccessToken(token);
       
       //03 - Return the response to the user
       
       return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
   }
  
   @PostMapping("/addrole")
   public ResponseEntity<Role> addRole(@RequestBody Role role){
   	Role newRole = roleRepository.save(role);
   	return ResponseEntity.ok(newRole);
   }
  
   @PostMapping("/adduser")
   public ResponseEntity<User> addUser(@RequestBody User user){
   	User newUser = userRepository.save(user);
   	return ResponseEntity.ok(newUser);
   }
  
 
  
  
  
}
