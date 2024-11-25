package com.wipro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.model.Question;
@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

	List<Question> findByDifficultyLevel(String difficultyLevel);


}
