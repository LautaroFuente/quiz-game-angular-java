package com.quiz_game.quiz_game_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz_game.quiz_game_backend.DTO.ScoreDTO;
import com.quiz_game.quiz_game_backend.entities.Difficulty;
import com.quiz_game.quiz_game_backend.entities.Score;
import com.quiz_game.quiz_game_backend.entities.User;
import com.quiz_game.quiz_game_backend.service.DifficultyService;
import com.quiz_game.quiz_game_backend.service.ScoreService;

@RestController
@RequestMapping("/api")
public class ScoreController {

	@Autowired
	private ScoreService scoreservice;
	
	@Autowired
	private DifficultyService difficultyservice;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/score")
	public ResponseEntity<List<Score>> getAllScores(){
		return ResponseEntity.ok(this.scoreservice.getAllScores());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/score")
    public ResponseEntity<Score> saveScore(@RequestBody ScoreDTO scoreDTO) {

		Difficulty difficulty = difficultyservice.getOneDifficulty(scoreDTO.getDifficulty());
	    if (difficulty == null) {
	        return ResponseEntity.badRequest().body(null);
	    }
		User user = new User(scoreDTO.getUserName(), scoreDTO.getUserEmail());
		Score score = new Score(user, scoreDTO.getUserScore(), scoreDTO.isWin(), difficulty);
		this.scoreservice.addScore(score);
        return ResponseEntity.ok(score);
    }
}
