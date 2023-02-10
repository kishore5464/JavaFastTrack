package com.cts.jpahibdemo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("c")
//@Table(name="c_assosiates")
@Table(name="c_assosiates_only")
public class ContractAssosiate extends Assosiate {
	private Double contractDuration;
	
	public ContractAssosiate() {
		// TODO Auto-generated constructor stub
	}

	public ContractAssosiate(Long assId, String name, Double salary,Double contractDuration) {
		super(assId, name, salary);
		this.contractDuration=contractDuration;
	}

	public Double getContractDuration() {
		return contractDuration;
	}

	public void setContractDuration(Double contractDuration) {
		this.contractDuration = contractDuration;
	}
	

}
