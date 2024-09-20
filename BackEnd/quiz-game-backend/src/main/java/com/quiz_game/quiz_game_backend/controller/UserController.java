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

import com.quiz_game.quiz_game_backend.entities.User;
import com.quiz_game.quiz_game_backend.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userservice;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("user/all")
	public ResponseEntity<List<User>> getAllUsers(){
		
		return ResponseEntity.ok(this.userservice.getAllUsers());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("user")
	public ResponseEntity<User> getOneUser(@RequestParam String email){
		
		return ResponseEntity.ok(this.userservice.getOneUser(email));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("user")
	public ResponseEntity<User> addUser(@RequestBody User user){
		
		this.userservice.addUser(user);
		return ResponseEntity.ok(user);
	}
}
