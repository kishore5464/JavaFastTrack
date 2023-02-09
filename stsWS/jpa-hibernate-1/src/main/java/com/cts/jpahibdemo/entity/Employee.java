package com.cts.jpahibdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emps")
public class Employee implements Comparable<Employee> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	private String fullName;
	private Double salary;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Embedded
	private Address address;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "holder")
	private BankAccount salaryAccount;
	
	@ManyToOne
	private Departmnet dept;

	@Override
	public int compareTo(Employee o) {
		return empId!=null?empId.compareTo(o.empId) :-1;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Long empId, String fullName, Double salary, Gender gender, Address address,
			BankAccount salaryAccount, Departmnet dept) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.salary = salary;
		this.gender = gender;
		this.address = address;
		this.salaryAccount = salaryAccount;
		this.dept = dept;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public BankAccount getSalaryAccount() {
		return salaryAccount;
	}

	public void setSalaryAccount(BankAccount salaryAccount) {
		this.salaryAccount = salaryAccount;
	}

	public Departmnet getDept() {
		return dept;
	}

	public void setDept(Departmnet dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fullName=" + fullName + ", salary=" + salary + ", gender=" + gender
				+ ", address=" + address + ", salaryAccount=" + salaryAccount + "]";
	}
	
	
}
