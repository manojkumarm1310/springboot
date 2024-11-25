package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.model.Question;
import com.wipro.service.QuestionService;


@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/getAllQuestion")
	public List<Question> getAllQuestion() {
		return questionService.getAllQuestion();
	}
	
	@GetMapping("/getQuestionByDiff/{level}")
	public List<Question> getQuestionByCategory(@PathVariable(name="level") String level) {
		return questionService.getQuestionByCategory(level);
	}
	
	@PostMapping("/add")
	public Question addQuestion(@RequestBody Question question) {
		System.out.println(question);
		return questionService.addQuestion(question);
	}
	
	
	
	
}
