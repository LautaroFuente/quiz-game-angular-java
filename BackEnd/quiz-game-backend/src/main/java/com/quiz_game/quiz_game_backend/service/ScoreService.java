package com.quiz_game.quiz_game_backend.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.quiz_game.quiz_game_backend.entities.Score;
import com.quiz_game.quiz_game_backend.repository.ScoreRepository;

@Service
public class ScoreService {

	@Autowired
	private ScoreRepository scorerepository;
	
	public List<Score> getAllScores(){
		Pageable pageable = PageRequest.of(0, 7);
		return this.scorerepository.findTopScores(pageable);
	}
	
	public void addScore(Score score) {
		this.scorerepository.save(score);
	}
}
