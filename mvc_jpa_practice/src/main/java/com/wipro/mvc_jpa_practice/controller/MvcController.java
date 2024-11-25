package com.wipro.mvc_jpa_practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.mvc_jpa_practice.model.Users;
import com.wipro.mvc_jpa_practice.service.MvcService;



@RestController
public class MvcController {
	
	@Autowired
	private MvcService mvcService;
	
	@GetMapping("/getuser/{id}")
	public Users getMethodName(@PathVariable(name="id")Integer id) {
		return mvcService.getUserById(id);
	}
	
	@PostMapping("/add")
	public String postMethodName(@RequestBody Users user) {
		//TODO: process POST request
		String AddedUser=mvcService.addUsers(user);
		return "added";
	}
	@GetMapping("/list")
	public List<Users> getMethodName() {
		return mvcService.getList();
	}
	
	
	
	
}
