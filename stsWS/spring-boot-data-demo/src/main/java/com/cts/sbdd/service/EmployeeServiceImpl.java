package com.cts.sbdd.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sbdd.entity.Employee;
import com.cts.sbdd.exception.EmployeeNotFoundException;
import com.cts.sbdd.exceptions.DuplicateEmployeeRecordExcepton;
import com.cts.sbdd.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public List<Employee> getAll() {
		return empRepo.findAll();
	}

	@Override
	public List<Employee> getAllByName(String name) {
		return empRepo.findAllByFullName(name);
	}

	@Override
	public List<Employee> getAllJoinedBetween(LocalDate start, LocalDate end) {
		return empRepo.getAllJoinedBetween(start, end);
	}

	@Override
	public Employee add(Employee emp) throws DuplicateEmployeeRecordExcepton {
		if(emp.getEmpId()!=null && empRepo.existsById(emp.getEmpId())) {
			throw new DuplicateEmployeeRecordExcepton();
		}
		
		return empRepo.save(emp);
	}

	@Override
	public Employee update(Employee emp) throws EmployeeNotFoundException {
		if(emp.getEmpId()==null || !empRepo.existsById(emp.getEmpId())) {
			throw new EmployeeNotFoundException();
		}
		
		return empRepo.save(emp);
	}

	@Override
	public void delete(Long id) throws EmployeeNotFoundException {
		if(!empRepo.existsById(id)) {
			throw new EmployeeNotFoundException();
		}
		empRepo.deleteById(id);
	}

}
