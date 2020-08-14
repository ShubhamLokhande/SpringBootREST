package com.tilesdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tilesdemo.entity.User;
import com.tilesdemo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Transactional
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Transactional(readOnly = true)
	public User getUserByEmail(String email) {
		return userRepo.findUserByEmail(email);
	}
	
	@Transactional(readOnly = true)
	public User getUserById(long id) {
		return userRepo.findUserByUserId(id);
	}
	
	@Transactional
	public void deleteUserById(long id) {
		userRepo.deleteById(id);
	}

	
}
