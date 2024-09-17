package com.quiz_game.quiz_game_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz_game.quiz_game_backend.entities.Difficulty;
import com.quiz_game.quiz_game_backend.repository.DifficultyRepository;

@Service
public class DifficultyService {

	@Autowired
	private DifficultyRepository difficultyrepository;
	
	public List<Difficulty> getAllDifficulty(){
		return this.difficultyrepository.findAll();
	}
	
	public Difficulty getOneDifficulty(String name) {
		return this.difficultyrepository.findByName(name);
	}
}
