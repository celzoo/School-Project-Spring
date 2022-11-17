package com.example.mvc.school.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String name ;
	private String passWord;
	
	public Integer getId() {
		return Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
		this.passWord = pass.encode(passWord).toString();
	}
	
	public User(Integer id, String name, String passWord) {
		this.name = name;
		BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
		this.passWord = pass.encode(passWord).toString();
	}
	public User() {
		
	}
	
	
	

}
