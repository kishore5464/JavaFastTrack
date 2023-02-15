package com.cts.sbrd.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.cts.sbrd.entity.Employee;
import com.cts.sbrd.exceptions.DuplicateEmployeeRecordExcepton;
import com.cts.sbrd.exceptions.EmployeeNotFoundException;

public interface EmployeeService {
	List<Employee> getAll();
	Optional<Employee> getById(Long id);
	List<Employee> getAllByName(String name);
	List<Employee> getAllJoinedBetween(LocalDate start,LocalDate end);
	Employee add(Employee emp) throws DuplicateEmployeeRecordExcepton;
	Employee update(Employee emp) throws EmployeeNotFoundException;
	void delete(Long id) throws EmployeeNotFoundException;
}
