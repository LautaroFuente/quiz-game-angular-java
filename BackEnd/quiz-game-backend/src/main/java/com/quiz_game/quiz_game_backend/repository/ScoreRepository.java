package com.quiz_game.quiz_game_backend.repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quiz_game.quiz_game_backend.entities.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {

	@Query("SELECT s FROM Score s ORDER BY s.score DESC")
	List<Score> findTopScores(Pageable pageable);


}
