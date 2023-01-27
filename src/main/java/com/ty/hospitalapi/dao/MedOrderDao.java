package com.ty.hospitalapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospitalapi.dto.Encounter;
import com.ty.hospitalapi.dto.MedOrder;
import com.ty.hospitalapi.repository.MedOrderRepository;

@Repository
public class MedOrderDao {

	@Autowired
	private MedOrderRepository medOrderRepository;

	@Autowired
	private EncounterDao encounterDao;

	public MedOrder saveMedOrder(int encounter_Id, MedOrder medOrder) {
		Encounter encounter = encounterDao.getEncounterById(encounter_Id);
		if (encounter != null) {
			medOrder.setEncounter(encounter);
			medOrderRepository.save(medOrder);
			return medOrder;
		} else {
			return null;
		}
	}

	public List<MedOrder> getAllMedOrders() {
		return medOrderRepository.findAll();
	}

	public MedOrder getMedOrderById(int id) {
		Optional<MedOrder> optional=medOrderRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}else {
			return optional.get();
		}
	}

	public boolean deleteMedOrderById(int id) {
		Optional<MedOrder> optional=medOrderRepository.findById(id);
		if(optional.isEmpty()) {
			return false;
		}else {
			medOrderRepository.deleteById(id);
			return true;
		}
	}
	
	public MedOrder updateMedOrder(int id,MedOrder medOrder) {
		Optional< MedOrder> optional=medOrderRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}else {
			medOrderRepository.save(medOrder);
			return optional.get();
		}
	}
}
