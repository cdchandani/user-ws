package com.bits.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bits.ss.user.dto.LoginResponse;
import com.bits.ss.user.model.User;
import com.bits.ss.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;

	@PostMapping("/users/register")
	public User registerUser(@RequestBody User user ) {
		return service.registerUser(user);
	}
	
	@GetMapping("/users/login")
	public LoginResponse login(@RequestParam("email") String email, @RequestParam("password") String password) {
		return service.authenticateUser(email, password);
	}
	
	@GetMapping("/users/profile")
	public User getProfile(@RequestParam("email") String email) {
		return service.getProfile(email);
	}
	
}
