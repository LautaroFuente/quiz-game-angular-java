package com.quiz_game.quiz_game_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz_game.quiz_game_backend.entities.Question;
import com.quiz_game.quiz_game_backend.service.QuestionService;

@RestController
@RequestMapping("/api")
public class QuestionController {

	@Autowired
	private QuestionService questionservice;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/question/all")
	public ResponseEntity<List<Question>> getAllQuestions(){
		
		return ResponseEntity.ok(this.questionservice.getAllQuestions());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/question")
	public ResponseEntity<List<Question>> getQuestions(@RequestParam String difficulty){
		
		return ResponseEntity.ok(this.questionservice.getQuestionsForDifficulty(difficulty));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/question")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		
		this.questionservice.addQuestion(question);
		return ResponseEntity.ok(question);
	}
}
