package com.ty.hospitalapi.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name; 
	private String website;
	
	@OneToMany(mappedBy = "hospital")
	private List<Branch> branchs;
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public List<Branch> getBranchs() {
		return branchs;
	}
	public void setBranchs(List<Branch> branchs) {
		this.branchs = branchs;
	}
	@Override
	public String toString() {
		System.out.println("Hospital Id :      "+id);
		System.out.println("Hospital Name :    "+name);
		System.out.println("Hospital WebSite : "+website);
		System.out.println("Branch :           "+branchs);
		return "";
	}
}
