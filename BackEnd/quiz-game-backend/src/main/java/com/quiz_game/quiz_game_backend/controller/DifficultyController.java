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
import com.quiz_game.quiz_game_backend.entities.Difficulty;
import com.quiz_game.quiz_game_backend.service.DifficultyService;

@RestController
@RequestMapping("/api")
public class DifficultyController {

	@Autowired
	private DifficultyService difficultyservice;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/difficulty/all")
	public ResponseEntity<ApiResponseDTO<List<Difficulty>>> getAllDifficulty(){
		
		try {
            List<Difficulty> difficulties = difficultyservice.getAllDifficulty();
            return ResponseEntity.ok(new ApiResponseDTO<>(true, "Dificultades obtenidas exitosamente", difficulties));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponseDTO<>(false, "Error al obtener las dificultades: " + e.getMessage(), null));
        }
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/difficulty")
	public ResponseEntity<ApiResponseDTO<Difficulty>> getOneDifficulty(@RequestParam String name){
		if(name == null || name.isEmpty()) {
			return ResponseEntity.badRequest().body(new ApiResponseDTO<>(false, "El campo name no puede estar vacio o ser nulo", null));
		}
		try {
			Difficulty difficulty = this.difficultyservice.getOneDifficulty(name);
			return ResponseEntity.ok(new ApiResponseDTO<>(true, "Dificultad obtenida", difficulty));
			
		} catch(Exception e) {
			return ResponseEntity.status(500).body(new ApiResponseDTO<>(false, "Error al obtener la dificultad: " + e.getMessage(), null));
		}
	}
}
