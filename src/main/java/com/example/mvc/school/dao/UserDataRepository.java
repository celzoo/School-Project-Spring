package com.example.mvc.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mvc.school.model.User;

public interface UserDataRepository extends JpaRepository<User,Integer> {
	public User findByname(String name);

}