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

import com.quiz_game.quiz_game_backend.DTO.ApiResponseDTO;
import com.quiz_game.quiz_game_backend.entities.Question;
import com.quiz_game.quiz_game_backend.service.QuestionService;

@RestController
@RequestMapping("/api")
public class QuestionController {

	@Autowired
	private QuestionService questionservice;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/question/all")
	public ResponseEntity<ApiResponseDTO<List<Question>>> getAllQuestions(){
		
		try {
			List<Question> allQuestions = this.questionservice.getAllQuestions();
			return ResponseEntity.ok(new ApiResponseDTO<>(true, "Todas las preguntas obtenidas exitosamente", allQuestions));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(new ApiResponseDTO<>(false, "Error al obtener todas las preguntas: " + e.getMessage(), null));
		}
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/question")
	public ResponseEntity<ApiResponseDTO<List<Question>>> getQuestions(@RequestParam String difficulty){
		
		if(difficulty == null || difficulty.isEmpty()) {
			return ResponseEntity.badRequest().body(new ApiResponseDTO<>(false, "La dificultad no puede ser vacia o ser nulo", null));
		}
		try {
			List<Question> questionsForDifficulty = this.questionservice.getQuestionsForDifficulty(difficulty);
			return ResponseEntity.ok(new ApiResponseDTO<>(true, "Todas las preguntas para la dificultad obtenidas exitosamente", questionsForDifficulty));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(new ApiResponseDTO<>(false, "Error al obtener las preguntas de la dificultad: " + e.getMessage(), null));
		}
	
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/question")
	public ResponseEntity<ApiResponseDTO<Question>> addQuestion(@RequestBody Question question){
		
		if(question == null) {
			return ResponseEntity.badRequest().body(new ApiResponseDTO<>(false, "La pregunta a guardar no puede ser nulo", null));
		}
		try {
			this.questionservice.addQuestion(question);
			return ResponseEntity.ok(new ApiResponseDTO<>(true, "Pregunta agregada exitosamente", question));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(new ApiResponseDTO<>(false, "Error al agregar la pregunta: " + e.getMessage(), null));
		}

	}
}
