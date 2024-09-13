package com.quiz_game.quiz_game_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz_game.quiz_game_backend.entities.Question;
import com.quiz_game.quiz_game_backend.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionrepository;
	
	public List<Question> getAllQuestions(){
		return this.questionrepository.findAll();
	}
	
	public Question getOneQuestion() {
		return null;
	}
	
	public void addQuestion(Question question) {
		this.questionrepository.save(question);
	}
}
