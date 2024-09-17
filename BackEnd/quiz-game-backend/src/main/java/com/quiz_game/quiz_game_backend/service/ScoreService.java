package com.quiz_game.quiz_game_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz_game.quiz_game_backend.entities.Score;
import com.quiz_game.quiz_game_backend.repository.ScoreRepository;

@Service
public class ScoreService {

	@Autowired
	private ScoreRepository scorerepository;
	
	public List<Score> getAllScores(){
		return this.scorerepository.findAll();
	}
	
	public void addScore(Score score) {
		this.scorerepository.save(score);
	}
}
