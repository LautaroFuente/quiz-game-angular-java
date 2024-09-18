package com.quiz_game.quiz_game_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz_game.quiz_game_backend.entities.Answer;


public interface AnswerRepository extends JpaRepository<Answer, Long> {

	List<Answer> findByQuestion_Id(Long id);
	
}
