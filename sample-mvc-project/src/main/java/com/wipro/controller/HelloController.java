package com.wipro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.model.User;

@Controller
@RequestMapping("/hc")
public class HelloController {
@GetMapping("/hello")
public ModelAndView sayHello(@RequestParam(name="batch")String batchName,Model model){
	return new ModelAndView("hello","batch",batchName);
}

@GetMapping("/pth/{pathVariable}")
public String pathVariableTest(@PathVariable(name="pathVariable")String pathVariable,Model model) {
	model.addAttribute("pathVar",pathVariable);
	return "pathVariable";
}

@GetMapping("/users")
public String getUser(@RequestBody User user, Model model) {
	model.addAttribute("user", user);
	return "user_details";
}

}


