package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dao.QuestionDao;
import com.wipro.model.Question;

@Service
public class QuestionService {

	@Autowired
	private QuestionDao questionDao;
	
	public List<Question> getAllQuestion(){
		System.out.println(questionDao.findAll());
		return questionDao.findAll();
	}

	public List<Question> getQuestionByCategory(String cate) {
		// TODO Auto-generated method stub
		return questionDao.findByDifficultyLevel(cate);
	}

	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionDao.save(question);
	}
	
}
