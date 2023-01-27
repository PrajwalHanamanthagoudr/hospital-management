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

import com.ty.hospitalapi.dto.Branch;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.service.BranchService;

@RestController
public class BranchController {

	@Autowired
	private BranchService branchService;

	@PostMapping("hospital/{hospital_Id}/branches")
	public ResponseStructure<Branch> saveBranch(@PathVariable int hospital_Id, @RequestBody Branch branch) {
		return branchService.saveBranch(hospital_Id, branch);
	}

	@GetMapping("/branches")
	public ResponseStructure<List<Branch>> getAllBranches() {
		return branchService.getAllBranchs();
	}

	@GetMapping("/branches/{id}")
	public ResponseStructure<Branch> getBranchById(@PathVariable int id) {
		return branchService.getBranchById(id);
	}

	@PutMapping("/branches/{id}")
	public ResponseStructure<Branch> updateBranchById(@PathVariable int id, @RequestBody Branch branch) {
		return branchService.updateBranchById(id, branch);
	}

	@DeleteMapping("/branches{id}")
	public ResponseStructure<Branch> deleteBranchById(@PathVariable int id) {
		return branchService.deleteBranchById(id);
	}
}
