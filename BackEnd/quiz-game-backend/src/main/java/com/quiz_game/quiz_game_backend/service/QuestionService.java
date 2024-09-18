package com.quiz_game.quiz_game_backend.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz_game.quiz_game_backend.entities.Difficulty;
import com.quiz_game.quiz_game_backend.entities.Question;
import com.quiz_game.quiz_game_backend.repository.DifficultyRepository;
import com.quiz_game.quiz_game_backend.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionrepository;
	
	@Autowired
	private DifficultyRepository difficultyrespository;
	
	public List<Question> getAllQuestions(){
		return this.questionrepository.findAll();
	}
	
	public List<Question> getQuestionsForDifficulty(String difficulty) {
		Difficulty selectedDifficulty = this.difficultyrespository.findByName(difficulty);
		
		if(selectedDifficulty == null) {
			throw new RuntimeException("Dificultad no encontrada");
		}
		
		List<Question> questions = this.questionrepository.findByDifficulty(selectedDifficulty);
		
		if (questions.isEmpty()) {
            throw new RuntimeException("No hay preguntas disponibles para esta dificultad");
        }
		
	    Collections.shuffle(questions);
	    
	    return questions.subList(0, 10);
	}
	
	public void addQuestion(Question question) {
		this.questionrepository.save(question);
	}
}
