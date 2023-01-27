package com.ty.hospitalapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospitalapi.dto.Branch;
import com.ty.hospitalapi.dto.Hospital;
import com.ty.hospitalapi.repository.BranchRepository;
import com.ty.hospitalapi.repository.HospitalRepository;

@Repository
public class BranchDao {

	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	public Branch saveBranch(int hospital_Id,Branch branch) {
		Optional<Hospital> optional=hospitalRepository.findById(hospital_Id);
		if(optional.isEmpty()) {
			return null;
		}
		branch.setHospital(optional.get());
		branchRepository.save(branch);
		return branch;
	}
	
	public List<Branch> getAllBranchs(){
		return branchRepository.findAll();
	}
	
	public Branch getBranchById(int id) {
		Optional<Branch> optional=branchRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}else {
			return optional.get();
		}
	}
	
	public boolean deleteBranchById(int id) {
		Optional<Branch> optional=branchRepository.findById(id);
		if(optional.isEmpty()) {
			return false;
		}else {
			branchRepository.deleteById(id);
			return true;
		}
	}
	
	public String updateBranchById(int id,Branch branch) {
		Optional<Branch> optional=branchRepository.findById(id);
		if(optional.isEmpty()) {
			return "New Records Created";
		}else {
			branchRepository.save(branch);
			return "Successfuly updated.";
		}
	}
}
