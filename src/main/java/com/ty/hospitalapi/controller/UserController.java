package com.ty.hospitalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospitalapi.dto.Login;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.dto.User;
import com.ty.hospitalapi.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/users")
	public ResponseStructure<User> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@GetMapping("/users")
	public ResponseStructure<List<User>> allUsers() {
		return service.allUsers();
	}
	
	@GetMapping("/users/{id}")
	public ResponseStructure<User> getUserById(@PathVariable int id) {
			return service.getUserbyid(id);
	}

	@PutMapping("/users/{id}")
	public ResponseStructure<User> updateUserById(@PathVariable int id, @RequestBody User user) {
			return service.updateUserById(id, user);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseStructure<User> deleteUserById(@PathVariable int id) {
			return service.deleteUserById(id);
	}
	
	@PostMapping("/users/login")
	public ResponseStructure<User> validateUser(@RequestBody Login login) {
		return service.validateUser(login.getEmail(),login.getPassword());
	}
}
