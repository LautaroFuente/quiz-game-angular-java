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

import com.quiz_game.quiz_game_backend.DTO.ApiResponseDTO;
import com.quiz_game.quiz_game_backend.DTO.ScoreDTO;
import com.quiz_game.quiz_game_backend.entities.Difficulty;
import com.quiz_game.quiz_game_backend.entities.Score;
import com.quiz_game.quiz_game_backend.entities.User;
import com.quiz_game.quiz_game_backend.service.DifficultyService;
import com.quiz_game.quiz_game_backend.service.ScoreService;
import com.quiz_game.quiz_game_backend.service.UserService;

@RestController
@RequestMapping("/api")
public class ScoreController {

	@Autowired
	private ScoreService scoreservice;
	
	@Autowired
	private DifficultyService difficultyservice;
	
	@Autowired
	private UserService userservice;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/score")
	public ResponseEntity<ApiResponseDTO<List<Score>>> getAllScores(){
		try {
			List<Score> scores = this.scoreservice.getAllScores();
			return ResponseEntity.ok(new ApiResponseDTO<>(true, "Puntuaciones obtenidas exitosamente", scores));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(new ApiResponseDTO<>(false, "Error al obtener las puntuaciones: " + e.getMessage(), null));
		}

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/score")
    public ResponseEntity<ApiResponseDTO<Score>> saveScore(@RequestBody ScoreDTO scoreDTO) {
		
		if(scoreDTO == null) {
			return ResponseEntity.badRequest().body(new ApiResponseDTO<>(false, "La puntuacion a guardar no puede ser nulo", null));
		}
		try {
			Difficulty difficulty = difficultyservice.getOneDifficulty(scoreDTO.getDifficulty());
		    if (difficulty == null) {
		        return ResponseEntity.badRequest().body(null);
		    }
		    User user = this.userservice.getOneUser(scoreDTO.getUserEmail());
		    if(user == null) {
		    	return ResponseEntity.badRequest().body(new ApiResponseDTO<>(false, "El usuario que esta jugando no esta registrado", null));
		    }else {
				Score score = new Score(user, scoreDTO.getUserScore(), scoreDTO.isWin(), difficulty);
				this.scoreservice.addScore(score);
		        return ResponseEntity.ok(new ApiResponseDTO<>(true, "Puntuacion guardada exitosamente", score));
		    }
		
		} catch (Exception e) {
			return ResponseEntity.status(500).body(new ApiResponseDTO<>(false, "Error al agregar la puntuacion: " + e.getMessage(), null));
		}
		
    }
}
