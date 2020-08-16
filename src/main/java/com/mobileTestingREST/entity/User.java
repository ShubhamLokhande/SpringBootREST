package com.mobileTestingREST.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_tbl")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private long userId;
	
	@Column(name = "USER_NAME", nullable = false)
	private String name;
	
	@Column(name = "USER_EMAIL", unique = true)
	private String email;
	
	@Column(name = "USER_PASSWORD", nullable = false)
	private String password;

	@Column(name = "USER_ADDRESS", nullable = false)
	private String address;
	
	@Column(name = "USER_AVATAR", nullable = true)
	private String avatar;
	
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
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", avatar=" + avatar + "]";
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
