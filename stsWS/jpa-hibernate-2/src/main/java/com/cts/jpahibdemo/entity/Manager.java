package com.cts.jpahibdemo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("m")
//@Table(name="managers")
@Table(name="managers_only")
public class Manager extends Assosiate{
	private Double allowence;
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(Long assId, String name, Double salary,Double allowence) {
		super(assId, name, salary);
		this.allowence=allowence;
	}

	public Double getAllowence() {
		return allowence;
	}

	public void setAllowence(Double allowence) {
		this.allowence = allowence;
	}
	
	
}
