package com.ty.hospitalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.HospitalDao;
import com.ty.hospitalapi.dto.Hospital;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.exception.NoIdFoundException;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao dao;
	
	public ResponseStructure<Hospital> saveHospital(Hospital hospital) {
		ResponseStructure< Hospital> structure=new ResponseStructure<Hospital>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(dao.saveHospital(hospital));
		return structure;
	}

	public ResponseStructure<Hospital> getHospitalById(int id) {
		Hospital hospital=dao.getHospitalById(id);
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		if (hospital != null) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(hospital);
		} else {
			throw new NoIdFoundException("Hospital Id "+id+" is not there.");
		}
		return structure;
	}
	
	public ResponseStructure<List<Hospital>> getAllHospitals(){
		ResponseStructure<List<Hospital>> structure = new ResponseStructure<List<Hospital>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(dao.getAllHospitals());
		return structure;
	}
	
	public ResponseStructure<Hospital> deleteHospitalById(int id) {
		Hospital hospital=dao.getHospitalById(id);
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		if (hospital != null) {
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Hospital Successfuly Deleted...!");
			structure.setData(hospital);
		} else {
			throw new NoIdFoundException("Hospital Id "+id+" is not there.");
		}
		return structure;
	}
	
	public  ResponseStructure<Hospital> updateHospitaById(int id,Hospital hospital) {
		Hospital hospital2=dao.getHospitalById(id);
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		if (hospital2 != null) {
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Success");
			structure.setData(hospital);
		} else {
			throw new NoIdFoundException("Hospital Id "+id+" is not there.");
		}
		return structure;
	}
}
