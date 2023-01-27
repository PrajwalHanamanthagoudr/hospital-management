package com.ty.hospitalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.UserDao;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.dto.User;
import com.ty.hospitalapi.exception.InvalidUserException;
import com.ty.hospitalapi.exception.NoIdFoundException;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public ResponseStructure<User> saveUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(userDao.saveUser(user));
		return responseStructure;
	}

	public ResponseStructure<List<User>> allUsers() {
		ResponseStructure<List<User>> structure = new ResponseStructure<List<User>>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(userDao.allUsers());
		return structure;
	}

	public ResponseStructure<User> getUserbyid(int id) {
		User user = userDao.getUserbyid(id);
		ResponseStructure<User> structure = new ResponseStructure<User>();
		if (user != null) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(userDao.getUserbyid(id));
		} else {
			throw new NoIdFoundException("user "+id+" is not exist");
		}
		return structure; 
	}

	public ResponseStructure<User> updateUserById(int id, User user) {
		User user2 = userDao.getUserbyid(id);
		ResponseStructure<User> structure = new ResponseStructure<User>();
		if (user2 != null) {
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Success");
			structure.setData(userDao.saveUser(user));
		} else {
			throw new NoIdFoundException("user "+id+" is not exist");
		}
		return structure;
	}

	public ResponseStructure<User> deleteUserById(int id) {
		User user = userDao.getUserbyid(id);
		ResponseStructure<User> structure = new ResponseStructure<User>();
		if (user != null) {
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("User Successfuly Deleted...!");
			structure.setData(user);
		} else {
			throw new NoIdFoundException("user "+id+" is not exist");
		}
		return structure;
	}

	public ResponseStructure<User> validateUser(String email, String password) {
		User user = userDao.validateUser(email, password);
		ResponseStructure<User> structure = new ResponseStructure<User>();
		if (user != null) {
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Success");
			structure.setData(userDao.validateUser(email, password));
		} else {
			throw new InvalidUserException("User Not exist");
		}
		return structure;
	}
}
