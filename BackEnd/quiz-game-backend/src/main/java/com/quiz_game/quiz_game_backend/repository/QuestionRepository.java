package com.quiz_game.quiz_game_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz_game.quiz_game_backend.entities.Difficulty;
import com.quiz_game.quiz_game_backend.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	List<Question> findByDifficulty(Difficulty difficulty);
}
