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

import com.ty.hospitalapi.dto.Encounter;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.service.EncounterService;

@RestController
public class EncounterController {

	@Autowired
	private EncounterService encounterService;
	
	@PostMapping("/branch/{branch_Id}/person/{person_Id}/encounters")
	public ResponseStructure<Encounter> saveEncounter(@PathVariable int branch_Id,@PathVariable int person_Id,@RequestBody Encounter encounter){
		return encounterService.saveEncounter(branch_Id, person_Id, encounter);
	}
	
	@GetMapping("/encounters")
	public ResponseStructure<List<Encounter> > getAllEncounter(){
		return encounterService.getAllEncounters();
	}
	
	@GetMapping("/encounters/{id}")
	public ResponseStructure<Encounter> getEncounterById(@PathVariable int id){
		return encounterService.getEncounterById(id);
	}
	
	@PutMapping("/encounters/{id}")
	public ResponseStructure<Encounter> updateEncounterById(@PathVariable int id,@RequestBody Encounter encounter){
		return encounterService.updateEcounterById(id, encounter);
	}
	
	@DeleteMapping("/encounters/{id}")
	public ResponseStructure<String> deleteEncounterById(@PathVariable int id){
		return encounterService.deleteEncounterById(id);
	}
}
