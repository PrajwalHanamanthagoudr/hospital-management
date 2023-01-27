package com.ty.hospitalapi.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name; 
	private String email;
	private long phone;
	
	@OneToMany(mappedBy = "person")
	private List<Encounter>  encounter;
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public List<Encounter> getEncounters() {
		return encounter;
	}
	public void setEncounters(List<Encounter> encounter) {
		this.encounter = encounter;
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
}
