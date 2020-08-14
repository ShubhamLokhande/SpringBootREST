package com.tilesdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tilesdemo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	void deleteUserByEmail(String email);

	User findUserByEmail(String email);

	User findUserByUserId(Long id);
}
