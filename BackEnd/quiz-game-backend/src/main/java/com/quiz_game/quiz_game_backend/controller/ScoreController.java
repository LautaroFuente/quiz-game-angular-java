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

import com.quiz_game.quiz_game_backend.entities.Score;
import com.quiz_game.quiz_game_backend.service.ScoreService;

@RestController
@RequestMapping("/api")
public class ScoreController {

	@Autowired
	private ScoreService scoreservice;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/score")
	public ResponseEntity<List<Score>> getAllScores(){
		return ResponseEntity.ok(this.scoreservice.getAllScores());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/score")
    public ResponseEntity<Score> postData(@RequestBody String userName, String userEmail) {

 		//System.out.println("Datos recibidos: " + qrinfo.getId() + qrinfo.getName() + " " + qrinfo.getEmail() + " " + qrinfo.getDate());
 		//qrinfoservice.saveQr(qrinfo);
        return ResponseEntity.ok(null);
    }
}
