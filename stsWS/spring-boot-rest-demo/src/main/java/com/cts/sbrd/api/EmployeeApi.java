package com.cts.sbrd.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.sbrd.entity.Employee;
import com.cts.sbrd.exceptions.DuplicateEmployeeRecordExcepton;
import com.cts.sbrd.exceptions.EmployeeNotFoundException;
import com.cts.sbrd.service.EmployeeService;

@RestController
@RequestMapping("/emps")
public class EmployeeApi {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployeeAction(){
		return ResponseEntity.ok(empService.getAll());
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getByEmployeeIdAction(@PathVariable("empId") Long empId) throws EmployeeNotFoundException{
		Optional<Employee> emp = empService.getById(empId);
	
		if(!emp.isPresent()) {
			throw new EmployeeNotFoundException();
		}
		
		return ResponseEntity.ok(emp.get());
	}
	
	@DeleteMapping("/{empId}")
	public ResponseEntity<Void> deleteEmployeeByIdAction(@PathVariable("empId") Long empId) throws EmployeeNotFoundException{
		empService.delete(empId);	
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PostMapping
	public ResponseEntity<Employee> addEmployeeAction(@RequestBody Employee emp) throws DuplicateEmployeeRecordExcepton{
		return new ResponseEntity<Employee>(empService.add(emp),HttpStatus.CREATED);
	}
		
	@PutMapping
	public ResponseEntity<Employee> updateEmployeeAction(@RequestBody Employee emp) throws EmployeeNotFoundException{
		return new ResponseEntity<Employee>(empService.update(emp),HttpStatus.CREATED);
	}
}
