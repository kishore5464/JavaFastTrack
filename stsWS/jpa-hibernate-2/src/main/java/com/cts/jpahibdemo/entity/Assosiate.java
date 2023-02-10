package com.cts.jpahibdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
/*@Table(name="all_assosiates")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "assc_type",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("a")
*/

//@Inheritance(strategy = InheritanceType.JOINED)
//@Table(name = "assosiates")

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "assosiates_only")
public class Assosiate {

	@Id
	private Long assId;
	private String name;
	private Double salary;
	
	public Assosiate() {
		// TODO Auto-generated constructor stub
	}

	public Assosiate(Long assId, String name, Double salary) {
		super();
		this.assId = assId;
		this.name = name;
		this.salary = salary;
	}

	public Long getAssId() {
		return assId;
	}

	public void setAssId(Long assId) {
		this.assId = assId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
}
