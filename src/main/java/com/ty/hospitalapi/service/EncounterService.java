package com.ty.hospitalapi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.EncounterDao;
import com.ty.hospitalapi.dto.Encounter;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.exception.NoIdFoundException;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao encounterDao;

	public ResponseStructure<Encounter> saveEncounter(int branch_Id, int person_Id, Encounter encounter) {
		ResponseStructure<Encounter> structure = new ResponseStructure<Encounter>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		encounter.setJoinDateTime(LocalDateTime.now());
		structure.setData(encounterDao.saveEncounter(branch_Id, person_Id, encounter));
		return structure;
	}

	public ResponseStructure<List<Encounter>> getAllEncounters() {
		ResponseStructure<List<Encounter>> structure = new ResponseStructure<List<Encounter>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(encounterDao.getAllEncounters());
		return structure;
	}

	public ResponseStructure<Encounter> getEncounterById(int id) {
		Encounter encounter=encounterDao.getEncounterById(id);
		ResponseStructure<Encounter> structure = new ResponseStructure<Encounter>();
		if(encounter != null) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(encounterDao.getEncounterById(id));
		}else {
			throw new NoIdFoundException("Encounter " + id + " is not exist");
		}
		return structure;
	}

	public ResponseStructure<String> deleteEncounterById(int id) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		if(encounterDao.deleteEncounterById(id)) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData("encounter deleted successfully");
		}else {
			throw new NoIdFoundException("Encounter " + id + " is not exist");
		}
		return structure;
	}

	public ResponseStructure<Encounter> updateEcounterById(int id, Encounter encounter) {
		Encounter encounter2=encounterDao.getEncounterById(id);
		ResponseStructure<Encounter> structure=new ResponseStructure<Encounter>();
		if(encounter2 != null) {
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Success");
			structure.setData(encounterDao.updateEcounterById(id, encounter));
		}else {
			throw new NoIdFoundException("Encounter " + id + " is not exist");
		}
		return structure;
	}
}
