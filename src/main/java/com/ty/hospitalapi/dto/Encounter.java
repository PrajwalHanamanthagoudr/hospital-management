package com.ty.hospitalapi.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Encounter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDateTime joinDateTime;
	private LocalDateTime dischargeDateTime;
	private String reason;
	
	@ManyToOne
	@JoinColumn(name = "person_Id")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name ="branch_Id")
	private Branch branch;
	
	@OneToMany(mappedBy = "encounter")
	private List< MedOrder> medOrders;
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	
	public LocalDateTime getJoinDateTime() {
		return joinDateTime;
	}
	public void setJoinDateTime(LocalDateTime joinDateTime) {
		this.joinDateTime = joinDateTime;
	}
	public LocalDateTime getDischargeDateTime() {
		return dischargeDateTime;
	}
	public void setDischargeDateTime(LocalDateTime dischargeDateTime) {
		this.dischargeDateTime = dischargeDateTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public List<MedOrder> getMedOrders() {
		return medOrders;
	}
	public void setMedOrders(List<MedOrder> medOrders) {
		this.medOrders = medOrders;
	}
}
