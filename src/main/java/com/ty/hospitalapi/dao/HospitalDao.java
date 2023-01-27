package com.ty.hospitalapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospitalapi.dto.Hospital;
import com.ty.hospitalapi.repository.HospitalRepository;

@Repository
public class HospitalDao {

	@Autowired
	private HospitalRepository hospitalRepository;

	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	public Hospital getHospitalById(int id) {
		Optional<Hospital> optional = hospitalRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}
	}
	
	public List<Hospital> getAllHospitals(){
		return hospitalRepository.findAll();
	}
	
	public String deleteHospitalById(int id) {
		Optional<Hospital> optional=hospitalRepository.findById(id);
		if(optional.isEmpty()) {
			return "Id Does Not Exist";
		}else {
			hospitalRepository.deleteById(id);
			return "Data Deleted Successfuly..!";
		}
	}
	
	public  String updateHospitaById(int id,Hospital hospital) {
		Optional<Hospital> optional=hospitalRepository.findById(id);
		if(optional.isEmpty()) {
			return "new hospital Created";
		}else {
			hospitalRepository.save(hospital);
			return "updated Successfuly..!";
		}
	}
}
