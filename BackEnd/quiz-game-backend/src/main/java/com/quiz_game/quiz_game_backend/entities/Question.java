package com.quiz_game.quiz_game_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	@JoinColumn(name = "difficulty_id")
	@ManyToOne
	private Difficulty difficulty;
	
	public Question(String description, Difficulty difficulty) {
		super();
		this.description = description;
		this.difficulty = difficulty;
	}

	public Question() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public Long getId() {
		return id;
	}
	
	
}
