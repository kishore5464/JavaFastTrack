package com.cts.jpahibdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class BankAccount {

	@Id
	private String accNum;
	private String ifsccode;
	
	@OneToOne
	@JoinColumn
	private Employee holder;
	
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

	public BankAccount(String accNum, String ifsccode, Employee holder) {
		super();
		this.accNum = accNum;
		this.ifsccode = ifsccode;
		this.holder = holder;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public Employee getHolder() {
		return holder;
	}

	public void setHolder(Employee holder) {
		this.holder = holder;
	}

	@Override
	public String toString() {
		return "BankAccount [accNum=" + accNum + ", ifsccode=" + ifsccode + "]";
	}
	
	
}
