package com.quiz_game.quiz_game_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz_game.quiz_game_backend.entities.Difficulty;
import com.quiz_game.quiz_game_backend.service.DifficultyService;

@RestController
@RequestMapping("/api")
public class DifficultyController {

	@Autowired
	private DifficultyService difficultyservice;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/difficulty/all")
	public ResponseEntity<List<Difficulty>> getAllDifficulty(){
		
		return ResponseEntity.ok(this.difficultyservice.getAllDifficulty());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/difficulty")
	public ResponseEntity<Difficulty> getOneDifficulty(@RequestParam String name){
		
		return ResponseEntity.ok(this.difficultyservice.getOneDifficulty(name));
	}
}
