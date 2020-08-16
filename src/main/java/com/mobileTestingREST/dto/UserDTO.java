package com.mobileTestingREST.dto;

import java.io.Serializable;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1710160163748517836L;
	
	private long userId;
	private String name;
	private String email;
	private String password;
	private String address;
	private String avatar;
	private String passwordConfirm;
	
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
