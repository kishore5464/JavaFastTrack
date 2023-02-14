package com.cts.sbdd.service;

import java.time.LocalDate;
import java.util.List;

import com.cts.sbdd.entity.Employee;
import com.cts.sbdd.exception.EmployeeNotFoundException;
import com.cts.sbdd.exceptions.DuplicateEmployeeRecordExcepton;

public interface EmployeeService {
	List<Employee> getAll();
	List<Employee> getAllByName(String name);
	List<Employee> getAllJoinedBetween(LocalDate start,LocalDate end);
	Employee add(Employee emp) throws DuplicateEmployeeRecordExcepton;
	Employee update(Employee emp) throws EmployeeNotFoundException;
	void delete(Long id) throws EmployeeNotFoundException;
}
