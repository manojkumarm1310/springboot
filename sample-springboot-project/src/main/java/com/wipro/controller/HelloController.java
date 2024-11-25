package com.wipro.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
	//http://localhost:8081/
	@RequestMapping(value = "/", method = RequestMethod.GET )
	public String greetings() {
		return "Hello, Good Morning";
	}
}
