package com.ty.hospitalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.MedOrderDao;
import com.ty.hospitalapi.dto.MedOrder;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.exception.NoIdFoundException;

@Service
public class MedOrderService {

	@Autowired
	private MedOrderDao medOrderDao;

	public ResponseStructure<MedOrder> saveMedOrder(int encounter_Id, MedOrder medOrder) {
		ResponseStructure<MedOrder> structure = new ResponseStructure<MedOrder>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(medOrderDao.saveMedOrder(encounter_Id, medOrder));
		return structure;
	}

	public ResponseStructure<List<MedOrder>> getAllMedOrders() {
		ResponseStructure<List<MedOrder>> structure = new ResponseStructure<List<MedOrder>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(medOrderDao.getAllMedOrders());
		return structure;
	}

	public ResponseStructure<MedOrder> getMedOrderById(int id) {
		MedOrder medOrder = medOrderDao.getMedOrderById(id);
		ResponseStructure<MedOrder> structure = new ResponseStructure<MedOrder>();
		if (medOrder != null) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(medOrder);
		}else {
			throw new NoIdFoundException("MedOrder " + id + " is not exist");
		}
		return structure;
	}

	public ResponseStructure<MedOrder> deleteMedOrderById(int id) {
		MedOrder medOrder = medOrderDao.getMedOrderById(id);
		ResponseStructure<MedOrder> structure = new ResponseStructure<MedOrder>();
		if (medOrderDao.deleteMedOrderById(id)) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(medOrder);
		} else {
			throw new NoIdFoundException("Branch " + id + " is not exist");
		}
		return structure;
	}

	public ResponseStructure<MedOrder> updateMedOrder(int id, MedOrder medOrder) {
		MedOrder medOrder2=medOrderDao.getMedOrderById(id);
		ResponseStructure<MedOrder> structure=new ResponseStructure<MedOrder>();
		if(medOrder2 != null) {
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Success");
			structure.setData(medOrderDao.updateMedOrder(id, medOrder));
		}else {
			throw new NoIdFoundException("Encounter " + id + " is not exist");
		}
		return structure;
	}
}
