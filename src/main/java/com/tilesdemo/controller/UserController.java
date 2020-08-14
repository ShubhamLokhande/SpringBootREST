package com.tilesdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tilesdemo.dto.UserDTO;
import com.tilesdemo.dtoMapper.UserDTOMapper;
import com.tilesdemo.entity.User;
import com.tilesdemo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	Create & Update Operations
	@PostMapping(path = "/save")
	public User saveUser(@RequestBody UserDTO userDTO) {
		User user = UserDTOMapper.mapToUser(userDTO);
		return userService.saveUser(user);
	}
	
//	Read Operations
	@GetMapping(path = "/email/{email}")
	public User getUserByEmail(@PathVariable(value = "email") String email) {
		return userService.getUserByEmail(email);
	}
	
	@GetMapping(path = "/id/{id}")
	public User getUserById(@PathVariable(value = "id") long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

//	Delete Operations
	@PostMapping(path = "/delete/{id}")
	public void deleteUser(@PathVariable(value = "id") long id) {
		userService.deleteUserById(id);
	}
}
