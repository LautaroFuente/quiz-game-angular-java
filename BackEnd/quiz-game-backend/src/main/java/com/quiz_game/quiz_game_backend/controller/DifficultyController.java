package com.quiz_game.quiz_game_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz_game.quiz_game_backend.service.DifficultyService;

@RestController
@RequestMapping("/api")
public class DifficultyController {

	@Autowired
	private DifficultyService difficultyservice;
}
