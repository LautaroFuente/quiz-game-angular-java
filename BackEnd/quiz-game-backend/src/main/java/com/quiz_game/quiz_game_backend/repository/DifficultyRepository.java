package com.quiz_game.quiz_game_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz_game.quiz_game_backend.entities.Difficulty;

public interface DifficultyRepository extends JpaRepository<Difficulty, Long>{

	Difficulty findByName(String nombre);
}
