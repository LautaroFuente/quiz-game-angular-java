package com.quiz_game.quiz_game_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz_game.quiz_game_backend.entities.Answer;
import com.quiz_game.quiz_game_backend.service.AnswerService;

@RestController
@RequestMapping("/api")
public class AnswerController {

	@Autowired
	private AnswerService answerservice;
	
	@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/answer")
    public ResponseEntity<List<Answer>> postData(@RequestParam Long questionId) {


        return ResponseEntity.ok(this.answerservice.getAnswersForQuestion(questionId));
    }

}
