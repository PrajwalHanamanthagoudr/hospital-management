package com.ty.hospitalapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospitalapi.dto.User;
import com.ty.hospitalapi.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository repository;

	public User saveUser(User user) {
		return repository.save(user);
	}

	public List<User> allUsers() {
		return repository.findAll();
	}

	public User getUserbyid(int id) {
		Optional<User> optional = repository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else
			return optional.get();
	}

	public String updateUser(int id, User user) {
		Optional<User> optional = repository.findById(id);
		if (optional.isEmpty()) {
			return "new User created";
		} else
			repository.save(user);
		return "User Updated Successfuly...!";
	}

	public String deleteUser(int id) {
		Optional<User> optional = repository.findById(id);
		if (optional.isEmpty()) {
			return "No Id";
		} else
			repository.deleteById(id);
		return "User Id Successfuly Deleted";
	}

	public User validateUser(String email, String password) {
		return repository.validateUser(email, password);
	}
}
