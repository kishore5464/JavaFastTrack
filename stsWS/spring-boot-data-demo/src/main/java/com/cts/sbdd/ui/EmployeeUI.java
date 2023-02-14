package com.cts.sbdd.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cts.sbdd.entity.Employee;
import com.cts.sbdd.exception.EmployeeNotFoundException;
import com.cts.sbdd.exceptions.DuplicateEmployeeRecordExcepton;
import com.cts.sbdd.service.EmployeeService;

@Component
public class EmployeeUI implements CommandLineRunner{

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private DateTimeFormatter dateFormatter;
	
	@Autowired
	private Scanner scanner;
	
	@Override
	public void run(String... args) throws Exception {
		
		int option = -1;
		
		while(option!=5) {
			System.out.println("1.Add");
			System.out.println("2.Delete");
			System.out.println("3.List All");
			System.out.println("4.Search By Name");
			System.out.println("5.Quit");
			
			System.out.println("Option? ");
			option = scanner.nextInt();
			
			switch(option) {
			case 1: addEmployee(); break;
			case 2: deleteEmployee(); break;
			case 3: displayAllEmployees(); break;
			case 4: displayEmpsGivenName(); break;
			case 5: System.out.println("BYE"); break;
			default: System.out.println("Invalid Option");
			}
		}
	}

	private void addEmployee() {
		
		Employee emp = new Employee();
		
		System.out.println("Name? ");
		emp.setFullName(scanner.next());
		System.out.println("Mail Id? ");
		emp.setMailId(scanner.next());
		System.out.println("Basic Pay? ");
		emp.setBasicPay(scanner.nextDouble());
		System.out.println("Date Of Joining (dd-MM-yyyy) ? ");
		emp.setDateOfJoining(LocalDate.parse(scanner.next(),dateFormatter));
		
		try {
			emp = empService.add(emp);
			System.out.println("Employee added with id#"+emp.getEmpId());
		} catch (DuplicateEmployeeRecordExcepton e) {
			System.out.println(e.getMessage());
		}
	}

	private void deleteEmployee() {
		
		System.out.println("Employee Id? ");
		Long empId = scanner.nextLong();
		
		try {
			empService.delete(empId);
			System.out.println("Employee deleted");
		} catch (EmployeeNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	void print(List<Employee> emps) {
		if(emps.isEmpty())
			System.out.println("No records found");
		else
			emps.stream().forEach(System.out::println);
	}
	
	void displayAllEmployees() {
		print(empService.getAll());
	}
	
	void displayEmpsGivenName() {
		System.out.println("Name? ");
		String name=scanner.next();
		print(empService.getAllByName(name));
	}
}
