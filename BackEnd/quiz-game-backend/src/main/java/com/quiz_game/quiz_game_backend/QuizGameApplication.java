package com.quiz_game.quiz_game_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizGameApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(QuizGameApplication.class, args);
		System.out.println("Aplicacion BackEnd Funcionando");
	}

}
