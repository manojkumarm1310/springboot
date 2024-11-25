package com.wipro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.model.Students;

@RestController
public class Controller {
	
	@GetMapping("/")
	public String getHome() {
		return "Hello";
	}

	@GetMapping("/students")
	public List<Students> getStudents(){
		
		List<Students> students=new ArrayList<>(List.of(
				new Students("manoj",22,"manoj@gmail.com"),new Students("kumar",12,"kumar@gmail.com")));
	return students;
	}
}
