package com.bits.ss.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bits.ss.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findUserByEmailAndPassword(String email, String password);
	User findUserByEmail(String email);

}
