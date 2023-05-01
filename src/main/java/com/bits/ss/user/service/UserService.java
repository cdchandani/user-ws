package com.bits.ss.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.ss.user.dto.LoginResponse;
import com.bits.ss.user.model.User;
import com.bits.ss.user.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public User registerUser(User user) {
		return repo.save(user);
	}

	public LoginResponse authenticateUser(String email, String password) {
		User user = repo.findUserByEmailAndPassword(email, password);
		return user != null?new LoginResponse(true,"token"):new LoginResponse(false, null);
	}

	public User getProfile(String email) {
		return repo.findUserByEmail(email);
	}
}
