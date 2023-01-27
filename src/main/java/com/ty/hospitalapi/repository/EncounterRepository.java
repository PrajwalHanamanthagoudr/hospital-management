package com.ty.hospitalapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.hospitalapi.dto.Encounter;

public interface EncounterRepository extends JpaRepository<Encounter, Integer>{

	@Query("SELECT e FROM Encounter e WHERE e.person.id=?1")
	List<Encounter> findEncounterByPerson(int id);
	
	@Query("SELECT e FROM Encounter e WHERE e.branch.id=?1")
	List<Encounter> findEncounterByBranch(int id);
}
