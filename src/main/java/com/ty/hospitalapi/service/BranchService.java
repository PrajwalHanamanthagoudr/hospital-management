package com.ty.hospitalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.BranchDao;
import com.ty.hospitalapi.dto.Branch;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.exception.NoIdFoundException;

@Service
public class BranchService {

	@Autowired
	private BranchDao branchDao;

	public ResponseStructure<Branch> saveBranch(int hospital_Id, Branch branch) {
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(branchDao.saveBranch(hospital_Id, branch));
		return structure;
	}

	public ResponseStructure<List<Branch>> getAllBranchs() {
		ResponseStructure<List<Branch>> structure = new ResponseStructure<List<Branch>>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(branchDao.getAllBranchs());
		return structure;

	}

	public ResponseStructure<Branch> getBranchById(int id) {
		Branch branch = branchDao.getBranchById(id);
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		if (branch != null) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(branchDao.getBranchById(id));
		} else {
			throw new NoIdFoundException("Branch " + id + " is not exist");
		}
		return structure;
	}

	public ResponseStructure<Branch> deleteBranchById(int id) {
		Branch branch = branchDao.getBranchById(id);
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		if (branch != null) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(branch);
		} else {
			throw new NoIdFoundException("Branch " + id + " is not exist");
		}
		return structure;
	}

	public ResponseStructure<Branch> updateBranchById(int id, Branch branch) {
		Branch branch2 = branchDao.getBranchById(id);
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		if (branch2 != null) {
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Success");
			structure.setData(branchDao.saveBranch(id, branch));
		} else {
			throw new NoIdFoundException("user " + id + " is not exist");
		}
		return structure;
	}
}
