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

import com.ty.hospitalapi.dto.Hospital;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.service.HospitalService;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	@PostMapping("/hospitals")
	public ResponseStructure<Hospital> saveHospital(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}

	@GetMapping("/hospitals")
	public ResponseStructure<List<Hospital>> getAllHospital() {
		return hospitalService.getAllHospitals();
	}

	@GetMapping("/hospitals/{id}")
	public ResponseStructure<Hospital> getHospitalById(@PathVariable int id) {
		return hospitalService.getHospitalById(id);
	}

	@PutMapping("/hospitals/{id}")
	public ResponseStructure<Hospital> updateHospitalById(int id, Hospital hospital) {
		return hospitalService.updateHospitaById(id, hospital);
	}

	@DeleteMapping("/hospitals/{id}")
	public ResponseStructure<Hospital> deleteHospitalById(int id) {
		return hospitalService.deleteHospitalById(id);
	}
}
