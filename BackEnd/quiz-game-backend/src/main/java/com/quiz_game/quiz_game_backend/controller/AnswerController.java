package com.quiz_game.quiz_game_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz_game.quiz_game_backend.DTO.ApiResponseDTO;
import com.quiz_game.quiz_game_backend.entities.Answer;
import com.quiz_game.quiz_game_backend.service.AnswerService;

@RestController
@RequestMapping("/api")
public class AnswerController {

	@Autowired
	private AnswerService answerservice;
	
	@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/answer")
    public ResponseEntity<ApiResponseDTO<List<Answer>>> getAnswers(@RequestParam Long questionId) {

		if(questionId == null || questionId < 0) {
			return ResponseEntity.badRequest().body(new ApiResponseDTO<>(false, "El id de la pregunta no puede ser menor a 0 o ser nulo", null));
		}
		try {
			List<Answer> answers = this.answerservice.getAnswersForQuestion(questionId);
			return ResponseEntity.ok(new ApiResponseDTO<>(true, "Respuestas obtenidas exitosamente", answers));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(new ApiResponseDTO<>(false, "Error al obtener las respuestas: " + e.getMessage(), null));
		}
    }

}