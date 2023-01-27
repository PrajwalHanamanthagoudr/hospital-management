package com.ty.hospitalapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.hospitalapi.dto.MedOrder;

public interface MedOrderRepository extends JpaRepository<MedOrder, Integer> {

	@Query("SELECT m FROM MedOrder m WHERE m.encounter.id=?1")
	List<MedOrder> findEncounterByEncounter(int id);

}
