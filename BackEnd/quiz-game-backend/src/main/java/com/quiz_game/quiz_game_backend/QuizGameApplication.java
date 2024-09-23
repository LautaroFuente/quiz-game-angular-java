package com.quiz_game.quiz_game_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class QuizGameApplication {

	public static void main(String[] args) {
		
		Dotenv dotenv = Dotenv.load();
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		
		SpringApplication.run(QuizGameApplication.class, args);
		System.out.println("Aplicacion BackEnd Funcionando");
	}

}
/*
 * TODO:Manejo errores en controladores:
 * 
 * Validación de Parámetros: Antes de llamar al servicio, puedes validar el parámetro para asegurarte de que no sea nulo o negativo.
 * Captura de Excepciones: Puedes capturar excepciones específicas que puedan ocurrir al obtener respuestas desde el servicio y devolver un mensaje de error adecuado.
 * Respuesta Estandarizada: Es útil devolver un objeto de respuesta estandarizado que incluya información sobre el éxito o el error.
 * */
 