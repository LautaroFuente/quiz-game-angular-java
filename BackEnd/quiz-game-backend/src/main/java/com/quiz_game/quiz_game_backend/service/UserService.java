package com.quiz_game.quiz_game_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz_game.quiz_game_backend.entities.User;
import com.quiz_game.quiz_game_backend.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userrepository;
	
	public List<User> getAllUsers(){
		return this.userrepository.findAll();
	}
	
	public User getOneUser(String email) {
		Optional<User> usuario = userrepository.findByEmail(email);
	    return usuario.orElse(null);
	}
	
	public void addUser(User user) {
		this.userrepository.save(user);
	}
}
