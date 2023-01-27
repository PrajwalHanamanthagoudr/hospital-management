package com.ty.hospitalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.PersonDao;
import com.ty.hospitalapi.dto.Person;
import com.ty.hospitalapi.dto.ResponseStructure;

@Service
public class PersonService {

	@Autowired
	private PersonDao dao;
	
	public ResponseStructure<Person> savePerson(Person person) {
		ResponseStructure<Person> structure=new ResponseStructure<Person>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(dao.savePerson(person));
		return structure;
	}
	
	public ResponseStructure<List<Person>> getAllPersons() {
		ResponseStructure<List<Person>> structure=new ResponseStructure<List<Person>>();
		return structure;
	}
	
	public ResponseStructure<Person> getPersonById(int id){
		Person person=dao.getPersonById(id);
		ResponseStructure<Person> structure=new ResponseStructure<Person>();
		if(person != null) {
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Success");
			structure.setData(dao.getPersonById(id));
		}else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Id Not Exist");
			structure.setData(null);
		}
		return structure;
	}
	
	public ResponseStructure<Person> deletePersonById(int id){
		ResponseStructure<Person> structure=new ResponseStructure<Person>();
		Person person=dao.getPersonById(id);
		if(person != null) {
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Success");
			structure.setData(person);
		}else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Person Id does Not Exist");
			structure.setData(null);
		}
		return structure;
	}
	
	public ResponseStructure<Person> updatePersonById(int id,Person person){
		ResponseStructure<Person> structure=new ResponseStructure<Person>();
		Person person2=dao.getPersonById(id);
		if(person2 != null) {
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Success");
			structure.setData(person);
		}else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("New Data Created..!");
			structure.setData(null);
		}
		return structure;
	}
}
