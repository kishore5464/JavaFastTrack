package com.cts.jsedemo.model;

import java.time.LocalDate;

public class Employee {

	private long empId;
	private String fullName;
	private double salary;
	private LocalDate dateOfJoing;
	
	public Employee() {
		
	}

	public Employee(long empId, String fullName, double salary, LocalDate dateOfJoing) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.salary = salary;
		this.dateOfJoing = dateOfJoing;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getDateOfJoing() {
		return dateOfJoing;
	}

	public void setDateOfJoing(LocalDate dateOfJoing) {
		this.dateOfJoing = dateOfJoing;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfJoing == null) ? 0 : dateOfJoing.hashCode());
		result = prime * result + (int) (empId ^ (empId >>> 32));
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (dateOfJoing == null) {
			if (other.dateOfJoing != null)
				return false;
		} else if (!dateOfJoing.equals(other.dateOfJoing))
			return false;
		if (empId != other.empId)
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fullName=" + fullName + ", salary=" + salary + ", dateOfJoing="
				+ dateOfJoing + "]";
	}
	
	
}
