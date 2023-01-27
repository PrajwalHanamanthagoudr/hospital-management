package com.ty.hospitalapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospitalapi.dto.Person;
import com.ty.hospitalapi.repository.PersonRepository;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepository personRepository;

	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	public Person getPersonById(int id) {
		Optional<Person> optional = personRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else
			return optional.get();
	}

	public boolean deletePersonById(int id) {
		Optional<Person> optional = personRepository.findById(id);
		if (optional.isEmpty()) {
			return false;
		} else
			personRepository.deleteById(id);
		return true;
	}
	
	public String updatePerson(int id,Person person) {
		Optional<Person> optional = personRepository.findById(id);
		if (optional.isEmpty()) {
			return "New Person Id created";
		} else
			personRepository.save(person);
		return "Person Details updated Successfully...!";
	}

}
