package com.ty.hospitalapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospitalapi.dto.Branch;
import com.ty.hospitalapi.dto.Encounter;
import com.ty.hospitalapi.dto.Person;
import com.ty.hospitalapi.repository.EncounterRepository;

@Repository
public class EncounterDao {

	@Autowired
	private EncounterRepository encounterRepository;

	@Autowired
	private BranchDao branchDao;

	@Autowired
	private PersonDao personDao;

	public Encounter saveEncounter(int branch_Id, int person_Id, Encounter encounter) {
		Branch branch = branchDao.getBranchById(branch_Id);
		Person person = personDao.getPersonById(person_Id);

		if (branch != null && person != null) {
			encounter.setBranch(branch);
			encounter.setPerson(person);
			encounterRepository.save(encounter);
			return encounter;
		} else {
			return null;
		}
	}

	public List<Encounter> getAllEncounters() {
		return encounterRepository.findAll();
	}

	public Encounter getEncounterById(int id) {
		Optional<Encounter> optional = encounterRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}
	}

	public boolean deleteEncounterById(int id) {
		Optional<Encounter> optional = encounterRepository.findById(id);
		if (optional.isEmpty()) {
			return false;
		} else {
			encounterRepository.deleteById(id);
			return true;
		}
	}

	public Encounter updateEcounterById(int id, Encounter encounter) {
		Optional<Encounter> optional = encounterRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			encounterRepository.save(encounter);
			return optional.get();
		}
	}
}
