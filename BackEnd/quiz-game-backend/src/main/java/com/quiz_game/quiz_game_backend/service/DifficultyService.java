package com.quiz_game.quiz_game_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz_game.quiz_game_backend.repository.DifficultyRepository;

@Service
public class DifficultyService {

	@Autowired
	private DifficultyRepository difficultyrepository;
}
