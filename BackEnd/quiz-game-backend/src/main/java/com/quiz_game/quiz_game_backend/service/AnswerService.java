package com.quiz_game.quiz_game_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz_game.quiz_game_backend.entities.Answer;
import com.quiz_game.quiz_game_backend.repository.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerrepository;
	
	public List<Answer> getAnswersForQuestion(Long id) {
		
		List<Answer> answers = this.answerrepository.findByQuestion_Id(id);
		
		if (answers.isEmpty()) {
            throw new RuntimeException("No hay respuestas disponibles para esta pregunta");
        }
		
	    
	    return answers;
	}
}
