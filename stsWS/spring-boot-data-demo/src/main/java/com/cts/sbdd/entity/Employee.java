package com.cts.sbdd.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sb_emps")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	private String fullName;
	private Double basicPay;
	private LocalDate dateOfJoining;
	private String mailId;
	
	public Employee() {
		
	}

	public Employee(Long empId, String fullName, Double basicPay, LocalDate dateOfJoining, String mailId) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.basicPay = basicPay;
		this.dateOfJoining = dateOfJoining;
		this.mailId = mailId;
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

	public Double getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(Double basicPay) {
		this.basicPay = basicPay;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fullName=" + fullName + ", basicPay=" + basicPay + ", dateOfJoining="
				+ dateOfJoining + ", mailId=" + mailId + "]";
	}
	
	
}
