package com.tilesdemo.dtoMapper;

import java.io.Serializable;

import com.tilesdemo.dto.UserDTO;
import com.tilesdemo.entity.User;

public class UserDTOMapper implements Serializable{

	private static final long serialVersionUID = 8364519647326314648L;

	public static User mapToUser(UserDTO userDTO) {
		User user = new User();
		user.setUserId(userDTO.getUserId());
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setAddress(userDTO.getAddress());
		return user;
	}
}
