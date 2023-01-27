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

import com.ty.hospitalapi.dto.MedOrder;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.service.MedOrderService;

@RestController
public class MedOrderController {

	@Autowired
	private MedOrderService medOrderService;

	@PostMapping("/{encounter_Id}/medorders")
	public ResponseStructure<MedOrder> saveMedOrder(@PathVariable int encounter_Id, @RequestBody MedOrder medOrder) {
		return medOrderService.saveMedOrder(encounter_Id, medOrder);
	}

	@GetMapping("/medorders")
	public ResponseStructure<List<MedOrder>> getAllMedOrders() {
		return medOrderService.getAllMedOrders();
	}

	@GetMapping("/medorders/{id}")
	public ResponseStructure<MedOrder> getMedOrderById(@PathVariable int id) {
		return medOrderService.getMedOrderById(id);
	}

	@PutMapping("/medorders/{id}")
	public ResponseStructure<MedOrder> updateMedOrder(@PathVariable int id, @RequestBody MedOrder medOrder) {
		return medOrderService.updateMedOrder(id, medOrder);
	}

	@DeleteMapping("/medorders/{id}")
	public ResponseStructure<MedOrder> deleteMedOrder(@PathVariable int id) {
		return medOrderService.deleteMedOrderById(id);
	}
}
