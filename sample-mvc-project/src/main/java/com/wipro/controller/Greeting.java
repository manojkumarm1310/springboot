package com.wipro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Greeting {
	@GetMapping("/hello")
	public String greeting(@RequestParam(name="firstName")String firstName,
						   @RequestParam(name="lastName",required=false,defaultValue="Mechatronics")String lastName,
						   Model model) {
		model.addAttribute("firstName",firstName);
		model.addAttribute("lastName",lastName);
		return "hellogreeting";
}
}
