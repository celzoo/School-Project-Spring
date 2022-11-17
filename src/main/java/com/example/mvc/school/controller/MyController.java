package com.example.mvc.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mvc.school.dao.UserDataRepository;
import com.example.mvc.school.model.User;

@Controller
public class MyController {
	
	@Autowired
	UserDataRepository repo;
	
	
	@RequestMapping("/")
	public String index() {
		return"register";
	}
	
	@RequestMapping("/register")
	public String registro() {
		return"register";
	}
	@RequestMapping("/saveUser")
	@ResponseBody
	public String saveUser(User user) {
		repo.save(user);
		return "Usuario Salvo Com Sucesso";
	}

	
	@RequestMapping("/users")
	public String users(Model model) {
		List<User> listUsers = repo.findAll();
	    model.addAttribute("listUsers", listUsers);
	   
	     
	    return "users";
	}
	@RequestMapping("/save")
	@ResponseBody
	public String save(User user) {
		repo.save(user);
		return "Usuario Salvo com sucesso";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Integer Id) {
		
		repo.deleteById(Id);
		return "Usuario Deletado Com Sucesso";
	}
	
	
	
	
	  
   
}
	
	


