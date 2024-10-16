package com.quiz_game.quiz_game_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.quiz_game.quiz_game_backend.DTO.ApiResponseDTO;
import com.quiz_game.quiz_game_backend.entities.User;
import com.quiz_game.quiz_game_backend.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userservice;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("user/all")
	public ResponseEntity<ApiResponseDTO<List<User>>> getAllUsers(){
		
		try {
			List<User> users = this.userservice.getAllUsers();
			return ResponseEntity.ok(new ApiResponseDTO<>(true, "Usuarios obtenidos exitosamente", users));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(new ApiResponseDTO<>(false, "Error al obtener todos los usuarios: " + e.getMessage(), null));
		}

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("user")
	public ResponseEntity<ApiResponseDTO<User>> getOneUser(@RequestParam String email){
		
		if(email == null || email.isEmpty()) {
			return ResponseEntity.badRequest().body(new ApiResponseDTO<>(false, "El email para buscar no puede ser vacio o ser nulo", null));
		}
		try {
			User user = this.userservice.getOneUser(email);
			return ResponseEntity.ok(new ApiResponseDTO<>(true, "Usuario obtenido exitosamente", user));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(new ApiResponseDTO<>(false, "Error al obtener el usuario con dicho email: " + e.getMessage(), null));
		}

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("user")
	public ResponseEntity<ApiResponseDTO<User>> addUser(@RequestBody User user){
		
		if(user == null) {
			return ResponseEntity.badRequest().body(new ApiResponseDTO<>(false, "El usuario a guardar no puede ser nulo", null));
		}
		try {
			User existUser = this.userservice.getOneUser(user.getEmail());
			if( existUser == null) {
				this.userservice.addUser(user);
				return ResponseEntity.ok(new ApiResponseDTO<>(true, "Usuario guardado exitosamente", user));	
			}else {
				return ResponseEntity.ok(new ApiResponseDTO<>(true, "Usuario existente logueado", user));
			}
			
			
		} catch (Exception e) {
			return ResponseEntity.status(500).body(new ApiResponseDTO<>(false, "Error al agregar el usuario: " + e.getMessage(), null));
		}

	}
}
